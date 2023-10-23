import java.util.Arrays;
import java.util.List;

/**
 * Diese Klasse speichert Musikalben in Form eines Objekt-Arrays,
 * welches mehrere Musikstücke beinhalten kann.
 * @author Andreas Sünder
 * @version 11-12-2020
 */
public class MusikAlbum {
    private String albumName;
    private String albumInterpret;
    private Musikstueck[] musikstuecke;

    /**
     * Erstellt ein MusikAlbum-Objekts aus allen gewünschten Werten,
     * aber mit einem leeren 'Musikstueck'-Array.
     * @param albumtitel Titel des Albums
     * @param albuminterpret Autor des Albums
     */
    public MusikAlbum(String albumtitel, String albuminterpret) {
        this.albumName = albumtitel;
        this.albumInterpret = albuminterpret;
        this.musikstuecke = new Musikstueck[]{};
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
     * Fügt das gegebene Musikstück zum internen Objekt-Array  hinzu.
     * @param m Musikstück, welches hinzugefügt werden soll
     */
    public void addMusikstueck(Musikstueck m) {
        boolean found_null = false;
        int pos_null = 0; // muss initialisiert werden
                          // sonst beschwert sich der Compiler
        int len = musikstuecke.length;

        for (int i=0; i<len; i++) {
            if (musikstuecke[i] == null) {
                found_null = true;
                pos_null = i;
                break;
            }
        }

        if (!found_null) {
            Musikstueck[] new_musikstuecke = new Musikstueck[len+1];
            for (int i=0; i<len; i++) {
                new_musikstuecke[i] = musikstuecke[i];
            }
            new_musikstuecke[len] = m;
            musikstuecke = new_musikstuecke;
        } else {
            musikstuecke[pos_null] = m;
        }
    }
    /**
     * Ähnlich wie obige Methode, hier werden aber alle gewünschten Werte
     * für das hinzuzufügende Musikstück gefordert.
     * @param titel Titel des hinzuzufügenden Musikstückes
     * @param interpret Interpret des hinzuzufügenden Musikstückes
     * @param dauer Dauer des hinzuzufügenden Musikstückes
     */
    public void addMusikstueck(String titel, String interpret, int dauer) {
        boolean found_null = false;
        int pos_null = 0;
        int len = musikstuecke.length;

        for (int i=0; i<len; i++) {
            if (musikstuecke[i] == null) {
                found_null = true;
                pos_null = i;
                break;
            }
        }

        if (!found_null) {
            Musikstueck[] new_musikstuecke = new Musikstueck[len+1];
            for (int i=0; i<len; i++) {
                new_musikstuecke[i] = musikstuecke[i].clone();
            }
            new_musikstuecke[len+1] = new Musikstueck(titel, interpret, dauer);
            musikstuecke = new_musikstuecke;
        } else {
            musikstuecke[pos_null] = new Musikstueck(titel, interpret, dauer);
        }
    }
    /**
     * Löscht das Musikstück aus dem internen Objekt-Array mit dem Index
     * 'nummerntitel-1'.
     * @param nummertitel Position des Stückes im Array (-1)'
     */
    public void removeMusikstueck(int nummertitel) {
        int len = musikstuecke.length;

        if (!(nummertitel > musikstuecke.length)) {
            musikstuecke[nummertitel-1] = null;
            Musikstueck[] new_musikstuecke = new Musikstueck[len-1];

            for (int i=nummertitel-1; i<len-1; i++) {
                new_musikstuecke[i] = musikstuecke[i+1];
            }
        }
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

    /**
     * Setzt den Titel des gewünschten Musikstücks des
     * internen Arrays.
     * @param index Stelle im Objekt-Array
     * @param titel gewünschter Titel des Musikstücks
     */
    public void changeTitel(int index, String titel) {
        musikstuecke[index].setTitel(titel);
    }
    /**
     * Setzt den Interpreten des gewünschten Musikstücks des
     * internen Arrays.
     * @param index Stelle im Objekt-Array
     * @param interpret gewünschter Interpret des Musikstücks
     */
    public void changeInterpret(int index, String interpret) {
        musikstuecke[index].setInterpret(interpret);
    }
    /**
     * Setzt die Dauer des gewünschten Musikstücks des
     * internen Arrays.
     * @param index Stelle im Objekt-Array
     * @param titel gewünschte Dauer des Musikstücks
     */
    public void changeDauer(int index, int dauer) {
        musikstuecke[index].setDauer(dauer);
    }

    /**
     * Erstellt eine tiefe Kopie des aktuellen Musikalbums
     * und gibt dieses zurück.
     * @return geklontes Objekt
     */
    public MusikAlbum clone() {
        MusikAlbum k_album = new MusikAlbum(albumName, albumInterpret);
        k_album.musikstuecke = new Musikstueck[musikstuecke.length];
        for (int i=0; i<musikstuecke.length; i++) {
            if (musikstuecke[i] != null)
                k_album.musikstuecke[i] = musikstuecke[i].clone();
        }
        return k_album;
    }
}


