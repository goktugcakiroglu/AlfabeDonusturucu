package com.example.alphabetconverter;

import java.util.HashMap;
import java.util.Map;

public class KirilToLatinStrategy implements TranslationStrategy {

    private static final Map<Character, String> dictionary = new HashMap<>();

    static {
        dictionary.put('\u0410', "A"); // А
        dictionary.put('\u0411', "B"); // Б
        dictionary.put('\u0416', "J"); // Ж
        dictionary.put('\u0427', "Ç"); // Ч
        dictionary.put('\u0414', "D"); // Д
        dictionary.put('\u0415', "E"); // Е
        dictionary.put('\u0424', "F"); // Ф
        dictionary.put('\u0413', "G"); // Г
        dictionary.put('\u0492', "Ğ"); // Ғ
        dictionary.put('\u0425', "H"); // Х
        dictionary.put('\u042B', "I"); // Ы
        dictionary.put('\u0418', "İ"); // И
        dictionary.put('\u041A', "K"); // К
        dictionary.put('\u041B', "L"); // Л
        dictionary.put('\u041C', "M"); // М
        dictionary.put('\u041D', "N"); // Н
        dictionary.put('\u041E', "O"); // О
        dictionary.put('\u04E8', "Ö"); // Ө
        dictionary.put('\u041F', "P"); // П
        dictionary.put('\u0420', "R"); // Р
        dictionary.put('\u0421', "S"); // С
        dictionary.put('\u0428', "Ş"); // Ш
        dictionary.put('\u0422', "T"); // Т
        dictionary.put('\u0423', "U"); // У
        dictionary.put('\u04AE', "Ü"); // Ү
        dictionary.put('\u0412', "V"); // В
        dictionary.put('\u0419', "Y"); // Й
        dictionary.put('\u0417', "Z"); // З
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