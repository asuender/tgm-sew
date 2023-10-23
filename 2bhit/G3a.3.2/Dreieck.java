/**
 * Diese Klasse speichert ein Dreieck, wobei im Objekt selbst
 * nur die 3 Eckpunkte hinterlegt sind. Sie bietet auch Funktionen zur Ausgabe der Werte
 * oder das Vergleichen mit einem anderen Dreieck-Objekt.
 * @author Andreas Sünder
 * @version 2020-10-12
 */
public class Dreieck {
    private Punkt2D p1;
    private Punkt2D p2;
    private Punkt2D p3;
    
    /** 
     * Erstellt ein leeres Dreieck.
     */
    public Dreieck() {}
    /**
     * Erstellt ein Dreieck und initialisiert die Punkte mit den angegebenen Parametern.
     * @param p1_ ErsterPunkt
     * @param p2_ Zweiter Punkt
     * @param p3_ Dritter Punkt
     */
    public Dreieck (Punkt2D p1_, Punkt2D p2_, Punkt2D p3_) {
        this.p1 = p1_;
        this.p2 = p2_;
        this.p3 = p3_;
    }
    
    /**
     * Übernimmt das Punkt2D-Objekt vom Paramter für den ersten hinterlegten Eckpunkt.
     * @param p1_ Objekt, welches für den ersten Eckpunkt übernommen wird.
     */
    public void setP1 (Punkt2D p1_) {
        this.p1 = p1_;
    }
    /**
     * Übernimmt das Punkt2D-Objekt vom Paramter für den zweiten hinterlegten Eckpunkt.
     * @param p1_ Objekt, welches für den zweiten Eckpunkt übernommen wird.
     */
    public void setP2 (Punkt2D p2_) {
        this.p2 = p2_;
    }
    /**
     * Übernimmt das Punkt2D-Objekt vom Paramter für den dritten hinterlegten Eckpunkt.
     * @param p1_ Objekt, welches für den dritten Eckpunkt übernommen wird.
     */
    public void setP3 (Punkt2D p3_) {
        this.p3 = p3_;
    }
    
    /**
     * Gibt den ersten Eckpunkt als Objekt zurück.
     * @return erster Eckpunkt.
     */
    public Punkt2D getP1() {
        return this.p1;
    }
    /**
     * Gibt den zweiten Eckpunkt als Objekt zurück.
     * @return zweiten Eckpunkt.
     */
    public Punkt2D getP2() {
        return this.p2;
    }
    /**
     * Gibt den dritten Eckpunkt als Objekt zurück.
     * @return dritten Eckpunkt.
     */
    public Punkt2D getP3() {
        return this.p3;
    }
    
    /**
     * Gibt die Koordinaten aller Eckpunkte als String zurück.
     * @return String-Representation aller Punkte.
     */
    public String toString() {
        return "p1: ("+this.p1.getX()+"|"+this.p1.getY()+")\n"+
               "p2: ("+this.p2.getX()+"|"+this.p2.getY()+")\n"+
               "p3: ("+this.p3.getX()+"|"+this.p3.getY()+")";
    }
    
    /**
     * Berechnet den Umfang des Dreiecks.
     * @return Umfang
     */
    public double umfang() {
        return this.p1.abstand(p2) + this.p2.abstand(p3) + this.p3.abstand(p1);
    }
    
    /**
     * Überprüft, ob die Werte aller Eckpunkte mit einem fremden Dreieck übereinstimmen.
     * @return "false", wenn die Werte unterschiedlich sind, ansonsten "true"
     */
    public boolean equals(Dreieck other) {
        return this.p1.equals(other.p1) &&
               this.p2.equals(other.getP2()) &&
               this.p3.equals(other.getP3());
    }
}
