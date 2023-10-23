package asuender.mathfigur;

/**
 * Inteface, welches alle Methoden für 'asuender.mathfigur.MathFigur' bereitstellt.
 * @author Andreas Suender
 * @version 04-01-2022
 */
public interface IMathFigur {
    int millimeter = 1;
    int zentimeter = 2;
    int meter = 3;
    int kilometer = 4;

    public void initialisieren();

    public double flaecheBerechnen();

    public double umfangBerechnen();

    public void setEinheit(int einheit);

    public int getEinheit();

    public boolean laengenCheck(double wert);

    public double umrechenFaktor();
}
