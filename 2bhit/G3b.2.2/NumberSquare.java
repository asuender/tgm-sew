/**
 * Diese Klasse spcihert eine quadratische Matrix aus beliebigen, ganzen Zahlen.
 * @author Andreas Suender
 * @version 11-27-2020
 */
public class NumberSquare {
    int[][] square;

    /**
     * Einfacher Konstruktor, nichts weiteres.
     * Setzt das Array auf eine 3x3 Matrix.
     */
    public NumberSquare() {
        square = new int[3][3];
    }
    /**
     * Überprüft, ob die gewünschte Zahl eh nicht kleiner/gleich 0 ist,
     * und setzt die Matrix dementsprechend.
     */
    public NumberSquare(int kante) {
        if (!(kante < 0)) // Hinweis. Man könnte hier auch 'if(kante>0)' schreiben,
                          // zur leichteren/besseren Verständnis habe ich es aber anders gemacht.
            square = new int[kante][kante];
    }

    /**
     * Überprüft & setzt die gewünschten Stelle in der Matrix auf den gewünschten Wert.
     * @param zeile gewünschte Zeile
     * @param spalte gewünschte Spalte
     * @param value gewünschter Wert
     */
    public void setNumber(int zeile, int spalte, int value) {
        if (!(zeile < 0) && !(spalte < 0) && !(value < 0))
            square[zeile][spalte] = value;
    }

    /**
     * Gibt den Wert an der gewünschten Stelle in der Matrix zurück.
     * @param zeile gewünschte Zeile
     * @param spalte gewünschte Spalte
     */
    public int getNumber(int zeile, int spalte) {
        if (!(zeile < 0) && !(spalte < 0))
            return square[zeile][spalte];
        return -1;
    }


    /**
     * Überprüft, ob alle Zeilen der angegebenen Summe entsprechen.
     * @param summe Summe, mit der die Zeilen überprüft werden sollen
     * @return 'true', wenn alles stimmen, sonst 'false'
     */
    public boolean checkRows(int summe) {
        int tmpSumme = 0;
        for (int i=0; i<square.length; i++) {
            for (int j=0; j<square[i].length; j++) {
                tmpSumme += square[i][j];
            }
            if (summe != tmpSumme) return false;
            tmpSumme=0;
        }
        return true;
    }
    /**
     * Überprüft, ob die alle Spalten der angegebenen Summe entsprechen.
     * @param summe Summe, mit der die Spalten überprüft werden sollen
     * @return 'true', wenn alles stimmen, sonst 'false'
     */
    public boolean checkColumns(int summe) {
        int tmpSumme = 0;
        for (int spalte = 0; spalte<square.length; spalte++) {
            for (int zeile = 0; zeile < square.length; zeile++) {
                tmpSumme += square[zeile][spalte];
            }
            if (summe != tmpSumme) return false;
            tmpSumme = 0;
        }
        return true;
    }
    /**
     * Überprüft, ob die beiden Diagonalen der angegebenen Summe entsprechen.
     * @param summe Summe, mit der die Diagonalen überprüft werden sollen
     * @return 'true', wenn alles stimmen, sonst 'false'
     */
    public boolean checkDiagonals(int summe) {
        int tmpSumme = 0;

        int spalte = 0;
        for (int i=0; i<square.length; i++) {
            tmpSumme += square[i][spalte];
            ++spalte;
        }
        System.out.println(tmpSumme);
        if (summe != tmpSumme) return false;

        // prüfen der Diagonalen e
        tmpSumme = 0;
        spalte = 0;
        for (int i=square.length-1; i>=0; i--) {
            tmpSumme += square[i][spalte];
            ++spalte;
        }
        System.out.println(tmpSumme);
        if (summe != tmpSumme) return false;

        return true;
    }

    /**
     * Überprüft die Matrix auf ein mögliches, "magisches Quadrat".
     * @return 'true', wenn dies zutrifft, sonst 'false'
     */
    public boolean isMagicSquare() {
        int summe = 0;

        // Summe zum Prüfen von der ersten Zeile bilden
        for (int j=0; j<square[0].length; j++)
            summe += square[0][j];
       
        if (checkRows(summe) && checkColumns(summe) && checkDiagonals(summe))
            return true;
        return false;
    }


    /**
     * Gibt die Matrix als String zurück.
     * @return String-Repräsentation der Matrix
     */
    public String stringForm() {
        String res = "";
        for (int i=0; i<square.length; i++) {
            for (int j=0; j<square[i].length; j++)
                res += square[i][j] + ",";
            res += "\n";
        }
        return res;
    }
}