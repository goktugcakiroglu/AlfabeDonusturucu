package com.example.alphabetconverter;

import java.util.HashMap;
import java.util.Map;
public class LatinToOsmanliStrategy implements TranslationStrategy {
    private static final Map<Character, String> dictionary = new HashMap<>();

    static {
        dictionary.put('A', "\u0627"); // Elif (ا)
        dictionary.put('B', "\u0628"); // Be (ب)
        dictionary.put('C', "\u062C"); // Cim (ج)
        dictionary.put('Ç', "\u0687"); // Çim (چ)
        dictionary.put('D', "\u062F"); // Dal (د)
        dictionary.put('E', "\u0647"); // He (ه)
        dictionary.put('F', "\u0641"); // Fe (ف)
        dictionary.put('G', "\u0643"); // Kef (ك)
        dictionary.put('Ğ', "\u063A"); // Gayın (غ) veya Kef
        dictionary.put('H', "\u062D"); // Ha (ح)
        dictionary.put('I', "\u064A"); // Ye (ی)
        dictionary.put('İ', "\u064A"); // Ye (ی)
        dictionary.put('J', "\u0698"); // Jale (ژ)
        dictionary.put('K', "\u0642"); // Kaf (ق) veya Kef
        dictionary.put('L', "\u0644"); // Lam (ل)
        dictionary.put('M', "\u0645"); // Mim (م)
        dictionary.put('N', "\u0646"); // Nun (ن)
        dictionary.put('O', "\u0648"); // Vav (و)
        dictionary.put('Ö', "\u0648"); // Vav (و)
        dictionary.put('P', "\u067E"); // Pe (پ)
        dictionary.put('R', "\u0631"); // Re (ر)
        dictionary.put('S', "\u0633"); // Sin (س)
        dictionary.put('Ş', "\u0634"); // Şın (ش)
        dictionary.put('T', "\u062A"); // Te (ت)
        dictionary.put('U', "\u0648"); // Vav (و)
        dictionary.put('Ü', "\u0648"); // Vav (و)
        dictionary.put('V', "\u0648"); // Vav (و)
        dictionary.put('Y', "\u064A"); // Ye (ی)
        dictionary.put('Z', "\u0632"); // Ze (ز)
    }
    @Override

    public String translate(String input) {
        if (input == null) return "";
        input = input.toUpperCase();
        StringBuilder translatedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            translatedText.append(dictionary.getOrDefault(c, String.valueOf(c)));
        }
        return translatedText.toString();
    }
}
