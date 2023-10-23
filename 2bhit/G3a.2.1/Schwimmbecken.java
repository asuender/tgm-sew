/**
 * Diese Klasse speichert die u.a. Daten wie Höhe, Breite und Länge eines Schwimmbeckens.
 * @version 2020-10-20
 * @author Andreas Suender
 */
public class Schwimmbecken {
    private int length, width, height;
    private int waterQuantity;
    
    /**
     * Initialisiert die Maße des Beckens mit den Werten der Parameter
     * @param _lenght Länge
     * @param _width Breite
     * @param _height Höhe
     */
    public Schwimmbecken(int _lenght, int _width, int _height) {
        this.length = _lenght;
        if (this.length < 0)
            this.length = 1;
        
        this.width = _width;
        if (this.width < 0)
            this.width = 1;
            
        this.height = _height;
        if (this.height < 0)
            this.height = 1;
            
        this.waterQuantity = 0;
    }
    
    /**
     * Setzt die Länge des Beckens.
     * @param gewünschte Länge
     */
    public void setLength(int _lenght) {
        this.length = _lenght;
    }
    
    /**
     * Setzt die Breite des Beckens.
     * @param gewünschte Breite
     */
    public void setWidth(int _width) {
        this.length = _width;
    }
    
    /**
     * Setzt die Höhe des Beckens.
     * @param gewünschte Höhe
     */
    public void setHeight(int _height) {
        this.height = _height;
    }
    
    /**
     * Gibt die Länge des Beckens zurück.
     * @return Länge
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Gibt die Breite des Beckens zurück.
     * @return Breite
     */
    public int getWidth() {
        return this.length;
    }
    
    /**
     * Gibt die Höhe des Beckens zurück.
     * @return Höhe
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Setzt die Füllmenge des Beckens und achtet auf mögliche, unsinnige Werte.
     * @param _quantity gewünschte Füllmenge.
     */
    public void setQuantity(int _quantity) {
        this.waterQuantity = _quantity;
        if (this.waterQuantity < 0 || this.volume() < this.waterQuantity)
            this.waterQuantity = 1;
    }
    
    /**
     * Gibt die Füllmenge des Beckens zurück.
     * @return Füllmenge
     */
    public int getQuantity() {
        return this.waterQuantity;
    }
    
    /**
     * Berechnet das Volumen des Beckens in Litern[l].
     * @return Volumen
     */
    public double volume() {
        return (width*height*length)/1000.0;
    }
    
    /**
     * Addiert den Wert des Paramters zu der bestehenden Füllmenge
     * und achtet auf mögliche, unsinnige Werte.
     * @param _quantity Füllmenge, die addiert werden soll
     */
    public void einfuellen(int _quantity) {
        if (_quantity >= 0) {
            this.waterQuantity += _quantity;
            if (this.volume() < this.waterQuantity)
                this.waterQuantity = (int)this.volume();
        }
    }
    
    /**
     * Entfernt die gewünschte Menge an Wasser aus dem Becken
     * und achtet auf mögliche, unsinnige Werte.
     * @param zu entfernende Füllmenge.
     */
    public void auslassen(int _quantity) {
        if (_quantity >= 0) {
            this.waterQuantity -= _quantity;
            if (this.waterQuantity < 0)
                this.waterQuantity = 0;
        }
    }
    
    /**
     * Leert das Schwimmbecken.
     */
    public void leeren() {
        this.waterQuantity = 0;
    }
    
    /**
     * Gibt alle Werte des Beckens in Textform zurück.
     * @return Status
     */
    public String status() {
        return "l/b/h: "+
               this.length + "/" +
               this.width  + "/" +
               this.height + ", " + 
               "Füllmenge: " + this.waterQuantity;
    }
}
    
