package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.web.api.Abgabe;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModulTest {

        @Test
        void testToString() {
            //Eingabedaten
            String modulName = "Konfliktmanagement";
            String art = "WP";
            int semester = 4;
            String form = "PÜ";
            String sws = "2";
            int lp = 5;
            boolean belegt =false;
            boolean bestanden =false;


            //"System under test" aufsetzen
            Modul modul = new Modul(semester, modulName, art, form, sws, lp, belegt, bestanden);
            modul.setId(42L);

            //Erwartetes Ergebnis
            String expected = "Modul{id=42, modulName='Konfliktmanagement', semester=4, art='WP', form='PÜ', sws='2', lp=5, belegt=false, bestanden=false}";

            //Tatsächliches Ergebnis
            String actual = modul.toString();

            //Vergleich
            assertEquals(expected, actual);
        }
}
