package com.example.alphabetconverter;

import java.util.HashMap;import java.util.Map;public class LatinToGokturkStrategy implements TranslationStrategy {
    private static final Map<Character, String> dictionary = new HashMap<>();
    private static final String SESLILER = "AEIİOÖUÜ";

    static {
        // Sesli Harfler
        dictionary.put('A', "𐰀"); dictionary.put('E', "𐰀");
        dictionary.put('I', "𐰃"); dictionary.put('İ', "𐰃");
        dictionary.put('O', "𐰆"); dictionary.put('Ö', "𐰇");
        dictionary.put('U', "𐰆"); dictionary.put('Ü', "𐰇");

        // Sessiz Harfler (Temel Eşleştirmeler)
        dictionary.put('B', "𐰉");
        dictionary.put('C', "𐰲"); dictionary.put('Ç', "𐰲");
        dictionary.put('D', "𐰑");
        dictionary.put('F', "𐰯"); // Göktürkçede F yoktur, P (𐰯) kullanılır
        dictionary.put('G', "𐰍"); dictionary.put('Ğ', "𐰍");
        dictionary.put('H', "𐰴"); // Göktürkçede H yoktur, kalın K (𐰴) kullanılır
        dictionary.put('J', "𐰲"); // Göktürkçede J yoktur, C/Ç (𐰲) kullanılır
        dictionary.put('K', "𐰚");
        dictionary.put('L', "𐰞");
        dictionary.put('M', "𐰢");
        dictionary.put('N', "𐰣");
        dictionary.put('P', "𐰯");
        dictionary.put('R', "𐰺");
        dictionary.put('S', "𐰽"); dictionary.put('Ş', "𐰽");
        dictionary.put('T', "𐱃");
        dictionary.put('V', "𐰋"); // Göktürkçede V yoktur, ince B (𐰋) kullanılır
        dictionary.put('Y', "𐰖");
        dictionary.put('Z', "𐰔");
    }

    @Override
    public String translate(String input) {
        if (input == null) return "";
        input = input.toUpperCase();
        StringBuilder translatedText = new StringBuilder();
        boolean ilkSesliYazildi = false;

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                translatedText.append(" ");
                // Yeni kelimeye geçildiğinde sesli harf kuralı sıfırlanır
                ilkSesliYazildi = false;
                continue;
            }
            if (SESLILER.indexOf(c) != -1) {
                if (!ilkSesliYazildi) {
                    translatedText.append(ceviriYap(c));
                    ilkSesliYazildi = true;
                }
            } else {
                translatedText.append(ceviriYap(c));
            }
        }
        return translatedText.toString(); // Artık mobildeyiz, reverse() kullanmıyoruz!
    }

    private String ceviriYap(char c) {
        return dictionary.getOrDefault(c, String.valueOf(c));
    }
}
