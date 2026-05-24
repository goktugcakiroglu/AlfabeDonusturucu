package com.example.alphabetconverter;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleUnitTest {
    @Test
    public void ceviriTesti() {
        String testMetni = "ATARK";

        // Yeni Merkez (Hub) mimarisine göre testler
        System.out.println("--- GÖKTÜRK ÇIKTISI ---");
        System.out.println(TranslatorFactory.translateText(testMetni, "Latin", "Göktürk"));

        System.out.println("--- KİRİL ÇIKTISI ---");
        System.out.println(TranslatorFactory.translateText(testMetni, "Latin", "Kiril"));

        System.out.println("--- OSMANLI ÇIKTISI ---");
        System.out.println(TranslatorFactory.translateText(testMetni, "Latin", "Osmanlı"));

        // Tersine çeviri testi örneği
        System.out.println("--- TERSİNE ÇEVİRİ (KİRİL -> LATİN) ---");
        System.out.println(TranslatorFactory.translateText("АТАРК", "Kiril", "Latin"));
    }
}