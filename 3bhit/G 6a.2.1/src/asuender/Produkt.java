package asuender;

import java.io.Serializable;
import java.util.Objects;

/**
 * Diese Klasse repräsentiert ein Produkt.
 * @author asuender
 * @version 02/19/2021
 */
public class Produkt implements Comparable<Produkt>, Serializable {
    private long produktID;
    private String bezeichnung;
    private String beschreibung;
    private double preis;

    public Produkt() {
    }

    /**
     * Initialisiert ein neues {@link Produkt}-Objekt mit
     * einer Produkt-ID und dem Preis/Stück.
     * @param produktID Produkt-ID
     * @param preis Preis/Stück
     */
    public Produkt(long produktID, double preis) {
        this.produktID = produktID;
        this.preis = preis;
    }

    /**
     * Initalisiert ein komplettes {@link Produkt}-Objekt.
     * @param produktID Produkt-ID
     * @param bezeichnung Produktbezeichnung
     * @param beschreibung Produktbeschreibung
     * @param preis Preis/Stück
     */
    public Produkt(long produktID, String bezeichnung, String beschreibung, double preis) {
        this.produktID = produktID;
        this.bezeichnung = bezeichnung;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }

    /**
     * Gibt die Produkt-ID zurück.
     */

    public long getProduktID() {
        return produktID;
    }

    /**
     * Setzt die Produkt-ID auf den geg. Wert
     * @param produktID Produkt-ID
     */
    public void setProduktID(long produktID) {
        this.produktID = produktID;
    }

    /**
     * Gibt die Produktbeschreibung zurück.
     * @return Produktbeschreibung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setzt die Produktbescheibung auf den geg. String.
     * @param bezeichnung Produktbezeichnung
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * Gibt die Produktbeschreibung zurück.
     * @return Produktbeschreibung
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Stetzt die Produktbeschreibung auf den geg. String.
     *
     * @param beschreibung Produktbeschreibung
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    /**
     * Gibt den Preis/Stück zurück.
     *
     * @return Preis/Stück.
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Setzt den Preis/Stück auf den geg. Wert.
     *
     * @param preis Preis/Stück
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }

    /**
     * Berechnet den Gesamtpreis bei {@code stueckZahl} Anzahl von Produkten.
     *
     * @param stueckZahl Anzahl
     * @return Gesamtpreis
     */
    public double gesamtPreis(int stueckZahl) {
        return preis * stueckZahl;
    }

    /**
     * Gibt eine String-Repräsentation des Produktes zurück.
     *
     * @return String-Repräsentation
     */
    public String produktDaten() {
        return this.produktID +
                " - " + this.bezeichnung +
                ": " + this.beschreibung +
                " - " + this.preis;
    }

    @Override
    public String toString() {
        return produktDaten();
    }

    /**
     * Überprüft dieses Produkt mit einem fremden Produkt auf Gleichheit.
     * @param o fremdes Produkt
     * @return true, wenn beide Produkte gleich sind, andernfalls false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return getProduktID() == produkt.getProduktID() && Double.compare(produkt.getPreis(), getPreis()) == 0 && getBezeichnung().equals(produkt.getBezeichnung()) && getBeschreibung().equals(produkt.getBeschreibung());
    }

    /**
     * Liefert den Hashcode des aktuellen Produktes.
     * @return Hashcode des aktuellen Produktes
     */
    @Override
    public int hashCode() {
        return Objects.hash(getProduktID(), getBezeichnung(), getBeschreibung(), getPreis());
    }

    /**
     * Vergleicht ein Produkt mit einem anderen. Dabei wird auf dieselbe Reihenfolge
     * zurückgegriffen, wie die Attribute in der Klasse definiert sind:
     * Produkt-ID, Bezeichnung, Beschreibung, Preis
     * @param o anderes Produkt
     * @return -1, wenn das fremde Produkt größer ist; 0, wenn beide Produkte gleich sind; 1, wenn das fremde Produkt kleiner ist
     */
    @Override
    public int compareTo(Produkt o) {
        if (o == null) {
            return -1;
        }

        if (this.equals(o)) {
            return 0;
        }

        int ret = this.produktID - o.produktID > 0 ? 1 : this.produktID - o.produktID < 0 ? -1 : 0;
        if (ret != 0) {
            return ret;
        }

        ret = this.bezeichnung.compareTo(o.bezeichnung);
        if (ret != 0) {
            return ret;
        }

        ret = this.beschreibung.compareTo(o.beschreibung);
        if (ret != 0) {
            return ret;
        }

        ret = (int) (this.preis - o.preis);
        if (ret != 0) {
            return ret;
        }

        return 0;
    }
}