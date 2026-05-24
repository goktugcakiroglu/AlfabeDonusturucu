package com.example.alphabetconverter;

import java.util.HashMap;
import java.util.Map;
public class LatinToKirilStrategy implements TranslationStrategy {
    private static final Map<Character, String> dictionary = new HashMap<>();
    static {
        dictionary.put('A', "\u0410"); // А
        dictionary.put('B', "\u0411"); // Б
        dictionary.put('C', "\u0416"); // Ж (Genelde C/J için kullanılır)
        dictionary.put('Ç', "\u0427"); // Ч
        dictionary.put('D', "\u0414"); // Д
        dictionary.put('E', "\u0415"); // Е
        dictionary.put('F', "\u0424"); // Ф
        dictionary.put('G', "\u0413"); // Г
        dictionary.put('Ğ', "\u0492"); // Ғ
        dictionary.put('H', "\u0425"); // Х
        dictionary.put('I', "\u042B"); // Ы
        dictionary.put('İ', "\u0418"); // И
        dictionary.put('J', "\u0416"); // Ж
        dictionary.put('K', "\u041A"); // К
        dictionary.put('L', "\u041B"); // Л
        dictionary.put('M', "\u041C"); // М
        dictionary.put('N', "\u041D"); // Н
        dictionary.put('O', "\u041E"); // О
        dictionary.put('Ö', "\u04E8"); // Ө
        dictionary.put('P', "\u041F"); // П
        dictionary.put('R', "\u0420"); // Р
        dictionary.put('S', "\u0421"); // С
        dictionary.put('Ş', "\u0428"); // Ш
        dictionary.put('T', "\u0422"); // Т
        dictionary.put('U', "\u0423"); // У
        dictionary.put('Ü', "\u04AE"); // Ү
        dictionary.put('V', "\u0412"); // В
        dictionary.put('Y', "\u0419"); // Й
        dictionary.put('Z', "\u0417"); // З

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