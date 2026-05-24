package com.example.alphabetconverter;

public class TranslatorFactory {

    // 1. Adım: Herhangi bir alfabeden Latin'e dönüştüren köprüler
    private static TranslationStrategy getStrategyToLatin(String sourceAlphabet) {
        switch (sourceAlphabet) {
            case "Göktürk": return new GokturkToLatinStrategy();
            case "Kiril": return new KirilToLatinStrategy();
            case "Osmanlı": return new OsmanliToLatinStrategy();
            case "Latin": return input -> input; // Zaten Latin ise metne dokunma
            default: throw new IllegalArgumentException("Desteklenmeyen Kaynak: " + sourceAlphabet);
        }
    }

    // 2. Adım: Latin'den hedef alfabeye dönüştüren köprüler
    private static TranslationStrategy getStrategyFromLatin(String targetAlphabet) {
        switch (targetAlphabet) {
            case "Göktürk": return new LatinToGokturkStrategy();
            case "Kiril": return new LatinToKirilStrategy();
            case "Osmanlı": return new LatinToOsmanliStrategy();
            case "Latin": return input -> input; // Hedef Latin ise metne dokunma
            default: throw new IllegalArgumentException("Desteklenmeyen Hedef: " + targetAlphabet);
        }
    }

    // Ana Çeviri Motoru: MainActivity doğrudan burayı çağıracak
    public static String translateText(String input, String source, String target) {
        // Kaynak metni önce Latin'e çevir (Merkez)
        TranslationStrategy toLatin = getStrategyToLatin(source);
        String latinText = toLatin.translate(input);

        // Latin metni hedef alfabeye çevir
        TranslationStrategy fromLatin = getStrategyFromLatin(target);
        return fromLatin.translate(latinText);
    }
}