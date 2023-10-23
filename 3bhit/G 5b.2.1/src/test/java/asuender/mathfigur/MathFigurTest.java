package asuender.mathfigur;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Diese Klasse testet alle implementierten Methoden der KLasse {@link MathFigur}.
 * @author Andreas Suender
 * @version 04-01-2022
 */
class MathFigurTest {
    @Test
    @DisplayName("Einheiten setzen und zurückgeben")
    void setGetEinheit() {
        ConcreteMathFigur figur = new ConcreteMathFigur();

        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> figur.setEinheit(5)),
                () -> {
                    figur.setEinheit(1);
                    assertEquals(1, figur.getEinheit());
                });
    }

    @Test
    @DisplayName("Längen checken")
    void laengenCheck() {
        ConcreteMathFigur figur = new ConcreteMathFigur();

        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> figur.laengenCheck(-1)),
                () -> {
                    figur.setEinheit(1);
                    assertTrue(figur.laengenCheck(5));
                    assertFalse(figur.laengenCheck(11));
                }, () -> {
                    figur.setEinheit(2);
                    assertTrue(figur.laengenCheck(5));
                    assertFalse(figur.laengenCheck(101));
                }, () -> {
                    figur.setEinheit(3);
                    assertTrue(figur.laengenCheck(5));
                    assertFalse(figur.laengenCheck(1001));
                }, () -> {
                    figur.setEinheit(4);
                    assertTrue(figur.laengenCheck(5));
                    assertFalse(figur.laengenCheck(0.1));
                });
    }

    @Test
    @DisplayName("Faktoren auf Meter bilden")
    void umrechenFaktor() {
        ConcreteMathFigur figur = new ConcreteMathFigur();

        assertAll(() -> {
            figur.setEinheit(1);
            assertEquals(1000, figur.umrechenFaktor());
        }, () -> {
            figur.setEinheit(2);
            assertEquals(100, figur.umrechenFaktor());
        }, () -> {
            figur.setEinheit(3);
            assertEquals(1, figur.umrechenFaktor());
        }, () -> {
            figur.setEinheit(4);
            assertEquals(0.001, figur.umrechenFaktor());
        });
    }
}