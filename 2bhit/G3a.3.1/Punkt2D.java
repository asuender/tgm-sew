/**
 * Diese Klasse speichert einen X & Y-Wert als Koordinaten eines Punktes.
 * @author Andreas Sünder
 * @version 2020-10-12
 */
public class Punkt2D {
    private int x;
    private int y;
    
    /**
     * Erstellt einen Punkt mit den Koordinaten 0|0.
     */
    public Punkt2D () {
        this(0, 0);
    }
    /**
     * Erstellt einen Punkt auf die gegebenen Werte.
     */
    public Punkt2D (int x_, int y_) {
        this.x = x_;
        this.y = y_;
    }
    
    /**
     * Setzt den X-Wert auf die gegebenen Werte.
     * @param x_ gewünschter X-Wert.
     */
    public void setX(int x_) { this.x = x_; }
    /**
     * Gibt den X-Wert des aktuellen Punktes zurück.
     * @return X-Wert.
     */
    public int getX() { return this.x; }
    /**
     * Setzt den Y-Wert auf die gegebenen Werte.
     * @param y_ gewünschter Y-Wert.
     */
    public void setY(int y_) { this.y = y_; }
    /**
     * Gibt den Y-Wert des aktuellen Punktes zurück.
     * @return Y-Wert.
     */
    public int getY() { return this.y; }
    
    /**
     * Vergleich die Werte des aktuellen Objekts mit denen eines fremden Punktes.
     * @param other Objekt, dessen Werte verglichen werden sollen.
     * @return "true", wenn die Koordinaten gleich sind, ansonsten "false"
     */
    public boolean equals(Punkt2D other) {
        return this.x == other.getX() && this.y == other.getY();
    }
    
    /**
     * Gibt die Koordinaten des aktuellen Punktes als String zurück.
     * @return String-Representation des Punktes.
     */
    public String textDaten() { return "("+x+"/"+y+")"; }
    /**
     * Berechnet den Abstand des Punktes zu 0|0.
     * @return Abstand zu 0|0 als Dezimalzahl.
     */
    public double abstandNull () {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
    
    /**
     * Berechnet den Abstand zu den Koordinaten des fremden Punktes.
     * @return Abstand zu den fremden Koordinaten als Dezimalzahl.
     */
    public double abstand(Punkt2D other) {
        return abstand(this, other);
    }
    
    /**
     * Berechnet den Abstand der gegebenen Punkte.
     * @return Abstand als Dezimalzahl
     */
    public static double abstand(Punkt2D one, Punkt2D two) {
        double base = Math.pow(two.x-one.x, 2) + Math.pow(two.y-one.y, 2);
        return Math.sqrt(base);
    }
}
