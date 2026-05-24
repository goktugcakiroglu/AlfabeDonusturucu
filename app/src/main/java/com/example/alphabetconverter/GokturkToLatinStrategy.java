package com.example.alphabetconverter;

public class GokturkToLatinStrategy implements TranslationStrategy {

    @Override
    public String translate(String input) {
        if (input == null) return "";

        String result = input;

        // Sesliler
        result = result.replace("𐰀", "A");
        result = result.replace("𐰃", "İ");
        result = result.replace("𐰆", "U");
        result = result.replace("𐰇", "Ü");

        // Sessizler
        result = result.replace("𐰉", "B");
        result = result.replace("𐰲", "C");
        result = result.replace("𐰑", "D");
        result = result.replace("𐰯", "P");
        result = result.replace("𐰍", "G");
        result = result.replace("𐰴", "K"); // Kalın K
        result = result.replace("𐰚", "K"); // İnce K
        result = result.replace("𐰞", "L");
        result = result.replace("𐰢", "M");
        result = result.replace("𐰣", "N");
        result = result.replace("𐰺", "R");
        result = result.replace("𐰽", "S");
        result = result.replace("𐱃", "T");
        result = result.replace("𐰋", "V");
        result = result.replace("𐰖", "Y");
        result = result.replace("𐰔", "Z");

        return result;
    }
}