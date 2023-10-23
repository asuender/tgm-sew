package asuender.mathfigur;

/**
 * Diese abstrakte Klasse implementiert jene Methoden des Interfaces {@link IMathFigur}, welche
 * für alle Subklassen gleich gelten und daher sinnvoll sind.
 */
public abstract class MathFigur implements IMathFigur {
    private int einheit = 3;

    /**
     * Setzt die Einheit des Objekts {@link IMathFigur}.
     * @throws IllegalArgumentException falls Einheit ungültig ist
     * @param einheit Einheit, welche gesetzt werden soll
     */
    @Override
    public void setEinheit(int einheit) {
        if (!(einheit >= 0 && einheit <= 4)) {
            throw new IllegalArgumentException("Einheit ist ungültig!");
        }
        this.einheit = einheit;
    }

    /**
     * Gibt die aktuelle Einheit des Objekts zurück.
     * @return die aktuelle Einheit des Objekts
     * @see IMathFigur
     */
    @Override
    public int getEinheit() {
        return this.einheit;
    }

    /**
     * Überprüft eine gegebene Länge auf Gültigkeit. Dabei werden auf folgenden Kriterien geachtet:
     *      - Wert ist nicht negativ
     *      - Wert liegt nicht zwischen 0 und 1, da die jeweils darunterliegende Einheit sinnvoller wäre
     *      - Wert liegt nicht über dem typischen Bereich der aktuellen Einheit, da die jeweils höher liegende Einheit sinnvoller wäre
     * @param wert Wert der zu überprüfende Länge
     * @throws IllegalArgumentException falls Wert negativ ist
     * @return true, falls Wert gültig ist, sonst false
     */
    @Override
    public boolean laengenCheck(double wert) {
        if (wert < 0) {
            throw new IllegalArgumentException("Wert darf nicht negativ sein!");
        }

        switch (this.einheit) {
            // Millimeter
            case 1:
                return !(wert >= 10 || wert < 1);

            // Zentimeter
            case 2:
                return !(wert >= 100 || wert < 1);
            // Meter
            case 3:
                return !(wert >= 1000 || wert < 1);

            case 4:
                return !(wert < 1);
        }

        return false;
    }

    /**
     * Gibt den Umrechnungsfaktor von der aktuellen Einheit auf die SI-Einheit Meter zurück.
     * @return Umrechnungsfaktor auf Meter
     */
    @Override
    public double umrechenFaktor() {
        int faktor = 1;

        switch (this.einheit) {
            case 1:
                faktor *= 10;
            case 2:
                faktor *= 100;
                break;

            case 3:
                return faktor;

            case 4:
                return 0.001;
        }

        return faktor;
    }
}
