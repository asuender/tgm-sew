import java.util.Arrays;
import java.util.List;

/**
 * Diese Klasse speichert Musikalben in Form eines Objekt-Arrays,
 * welches mehrere Musikstücke beinhalten kann.
 * @author Andreas Sünder
 * @version 11-23-2020
 */
public class MusikAlbum {
    private String albumName;
    private String albumInterpret;
    private Musikstueck[] musikstuecke;

    /**
     * Erstellt ein MusikAlbum-Objekts aus allen gewünschten Werten.
     * @param albumtitel Titel des Albums
     * @param albuminterpret Autor des Albums
     * @param anzahlMusikstuecke Anzahl der zu speichernden Musikstücke
     */
    public MusikAlbum(String albumtitel, String albuminterpret, byte anzahlMusikstuecke) {
        this.albumName = albumtitel;
        this.albumInterpret = albuminterpret;
        this.musikstuecke = new Musikstueck[anzahlMusikstuecke];
    }

    
    /**
     * Liefert den Albumnamen zurück.
     * @return Albumname
     */
    public String getAlbumName() {
        return albumName;
    }
    /**
     * Liefert den Albuminterpreten zurück.
     * @return Albuminterpreten
     */
    public String getAlbumInterpret() {
        return albumInterpret;
    }
    /**
     * Liefert das Objekt-Array mit den Musikstücken zurück.
     * @return Musikstücke
     */
    public Musikstueck[] getMusikstuecke() {
        return musikstuecke;
    }

    /**
     * Setzt den Albumtitel.
     * @param albumtitel Albumtitel
     */
    public void setAlbumName(String albumtitel) {
        this.albumName = albumtitel;
    }
    /**
     * Setzt den Albuminterpreten
     * @param albuminterpret Albuminterpret
     */
    public void setAlbumInterpret(String albuminterpret) {
        this.albumInterpret = albuminterpret;
    }
    /**
     * Setzt das Objekt-Array mit den Musikstücken
     * @param musikstuecke Musikstücke
     */
    public void setMusikstuecke(Musikstueck[] musikstuecke) {
        this.musikstuecke = musikstuecke;
    }


    /**
     * Addiert das gegebene Musikstück zum internen Objekt-Array.
     * @param m Musikstück, welches hinzugefügt werden soll
     * @return 'true', falls alles geklappt hat, sonst 'false'
     */
    public boolean addMusikstueck(Musikstueck m) {
        boolean success = false;
        for (int i=0; i<musikstuecke.length; i++) {
            if (musikstuecke[i] == null) {
                musikstuecke[i] = m;
                success = true;
                break;
            }
        }
        return success;
    }
    /**
     * Ähnlich wie obige Methode, hier werden aber alle gewünschten Werte
     * für das hinzuzufügende Musikstück gefordert.
     * @param titel Titel des hinzuzufügenden Musikstückes
     * @param interpret Interpret des hinzuzufügenden Musikstückes
     * @param dauer Dauer des hinzuzufügenden Musikstückes
     * @return 'true', falls alles geklappt hat, sonst 'false'
     */
    public boolean addMusikstueck(String titel, String interpret, int dauer) {
        boolean success = false;
        for (int i=0; i<musikstuecke.length; i++) {
            if (musikstuecke[i] != null) {
                musikstuecke[i] = new Musikstueck(titel, interpret, dauer);
                success = true;
            }
        }
        return success;
    }
    /**
     * Löscht das Musikstück aus dem internen Objekt-Array mit dem Index
     * 'nummerntitel-1'.
     * @param nummertitel Position des Stückes im Array (-1)
     * @return 'true', falls alles geklappt hat, sonst 'false'
     */
    public boolean removeMusikstueck(int nummertitel) {
        boolean succes = false;
        if (!(nummertitel > musikstuecke.length)) {
            musikstuecke[nummertitel-1] = null;
            for (int i=nummertitel-1; i<musikstuecke.length; i++) {
                if (i+1 < musikstuecke.length)
                    musikstuecke[i] = musikstuecke[i+1];
                else
                    musikstuecke[i] = null;
            }
        }
        return succes;
    }


    /**
     * Listet alle gespeicherten Musikstücke auf.
     * @return String-Repräsentation des Arrays
     */
    public String listMusikstuecke() {
        String res = "Album: "+albumName+" von "+albumInterpret+" mit einer Gesamtdauer von "+zeigeDauer()+"\n";
        Musikstueck temp;
        for (int i=0; i<musikstuecke.length; i++) {
            temp = musikstuecke[i];
            if (temp != null)
                res += " "+(i+1)+" "+temp.getTitel()+" von "+temp.getInterpret()+" ("+temp.getDauer()+")\n";
        }
        return res;
    }

    /**
     * Liefert die Dauer des gesamten Albums im Format
     * 'hh:mm:ss' zurück.
     * @return String-Repräsentation der gesamten Dauer
     */
    public String zeigeDauer() {
        int[] len = new int[]{ 0 };
        List<Musikstueck> liste = Arrays.asList(musikstuecke);
        liste.forEach(stueck -> {
            if (stueck != null)
                len[0]+=stueck.getDauer();
        });
        
        int h = len[0]/3600;
        int min = (len[0]%3600)/60;
        int sec = (len[0]%3600)%60;
        return h+":"+min+":"+sec;
    }
}


