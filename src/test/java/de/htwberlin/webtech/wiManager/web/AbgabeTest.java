package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.web.api.Abgabe;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbgabeTest {

    @Test
    void testToString() {
        //Eingabedaten
        String modulName = "WebTech";
        String notificationMessage = "Milestone 4";
        int semester = 3;
        LocalDate frist = LocalDate.of(2022, 12, 19);


        //"System under test" aufsetzen
        Abgabe abgabe = new Abgabe(semester, modulName, frist, notificationMessage);
        abgabe.setId(42L);

        //Erwartetes Ergebnis
        String expected = "Abgabe{id=42, semester=3, modulName='WebTech', frist=2022-12-19, notificationMessage='Milestone 4'}";

        //Tatsächliches Ergebnis
        String actual = abgabe.toString();

        //Vergleich
        assertEquals(expected, actual);
    }
}
