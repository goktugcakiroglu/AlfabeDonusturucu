package com.example.alphabetconverter;

import java.util.HashMap;
import java.util.Map;

public class OsmanliToLatinStrategy implements TranslationStrategy {

    private static final Map<Character, String> dictionary = new HashMap<>();

    static {
        dictionary.put('\u0627', "A"); // Elif
        dictionary.put('\u0628', "B"); // Be
        dictionary.put('\u062C', "C"); // Cim
        dictionary.put('\u0687', "Ç"); // Çim
        dictionary.put('\u062F', "D"); // Dal
        dictionary.put('\u0647', "E"); // He
        dictionary.put('\u0641', "F"); // Fe
        dictionary.put('\u0643', "K"); // Kef
        dictionary.put('\u063A', "Ğ"); // Gayın
        dictionary.put('\u062D', "H"); // Ha
        dictionary.put('\u064A', "İ"); // Ye (I/İ/Y)
        dictionary.put('\u0698', "J"); // Jale
        dictionary.put('\u0642', "K"); // Kaf
        dictionary.put('\u0644', "L"); // Lam
        dictionary.put('\u0645', "M"); // Mim
        dictionary.put('\u0646', "N"); // Nun
        dictionary.put('\u0648', "U"); // Vav (O/Ö/U/Ü)
        dictionary.put('\u067E', "P"); // Pe
        dictionary.put('\u0631', "R"); // Re
        dictionary.put('\u0633', "S"); // Sin
        dictionary.put('\u0634', "Ş"); // Şın
        dictionary.put('\u062A', "T"); // Te
        dictionary.put('\u0632', "Z"); // Ze
    }

    @Override
    public String translate(String input) {
        if (input == null) return "";
        StringBuilder translatedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            translatedText.append(dictionary.getOrDefault(c, String.valueOf(c)));
        }
        return translatedText.toString();
    }
}