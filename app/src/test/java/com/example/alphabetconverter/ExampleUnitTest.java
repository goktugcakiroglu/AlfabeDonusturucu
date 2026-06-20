package com.example.alphabetconverter;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void testHubAndSpokeArchitecture() {
        String testMetni = "ATARK";

        // Latin -> Göktürk Testi
        String gokturkSonuc = TranslatorFactory.translateText(testMetni, "Latin", "Göktürk");
        assertNotNull("Göktürk çevirisi null dönemez", gokturkSonuc);
        assertNotEquals("Göktürk çevirisi boş olamaz", "", gokturkSonuc);

        // Latin -> Kiril Testi
        String kirilSonuc = TranslatorFactory.translateText(testMetni, "Latin", "Kiril");
        assertEquals("Kiril dönüşümü hatalı!", "АТАРК", kirilSonuc);

        // Tersine Çeviri Testi (Kiril -> Latin)
        String latinSonuc = TranslatorFactory.translateText("АТАРК", "Kiril", "Latin");
        assertEquals("Tersine çeviri (Kiril -> Latin) hatalı!", "ATARK", latinSonuc);
        
        // Osmanlıca Testi (Sadece çökmediğinden emin olmak için basit null kontrolü)
        String osmanliSonuc = TranslatorFactory.translateText(testMetni, "Latin", "Osmanlı");
        assertNotNull("Osmanlıca çevirisi null dönemez", osmanliSonuc);
    }
}
