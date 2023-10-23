/**
 * In dieser Klasse gibt es nur eine einzige Methode, die eine ganze Zahl in eine römische Zahl umwandelt und zurückgibt (als String).
 * --- ERWEITERT ---
 * @author Andreas Suender
 * @version 2020-03-07
 */

public class Umwandeln {
    /**
     * Diese Methode wandelt eine ganze Zahl in eine römische Zahl um, wobei diee als String zurückgegeben wird.
     * --- ERWEITERT ---
     * Achtung: Ist der Parameter größer als 3999 oder kleiner als 1, so wird nichts zurückgegeben! (Leerer String)
     * @param zahl Ganze Zahl
     * @return römische Zahl als String
     */
    public static String roemer(int zahl) {
        String roemischeZahl = "";
        // Diese Variable ist nur am Anfang nötig, um festzustellen, mit welcher römischen Ziffer begonnen werden soll.
        int tempInt = 0;

        // Jedem römischen Bereich wird eine Zahl zugeordnert, damit auch mit der richtigen Ziffer begonnen werden kann.
        if (zahl >= 1 && zahl < 5)
            tempInt = 1;
        if (zahl >= 5 && zahl < 10)
            tempInt = 2;
        if (zahl >= 10 && zahl < 50)
            tempInt = 3;
        if (zahl >= 50 && zahl < 100)
            tempInt = 4;
        if (zahl >= 100 && zahl < 500)
            tempInt = 5;
        if (zahl >= 500 && zahl < 1000)
            tempInt = 6;
        if (zahl >= 1000 && zahl < 4000)
            tempInt = 7;

        // Diese Schleife geht jeden römischen Bereich durch und schaut, wie veile Buchstaben jeweils gesetzt werden müssen.
        for (int i = tempInt; i >= 1; i--) {
            if (i == 7) {
                for (int j = 0; j < zahl / 1000; j++) roemischeZahl += "M";
                zahl %= 1000;
            }
            if (i == 6) {
                for (int j = 0; j < zahl / 500; j++) roemischeZahl += "D";
                zahl %= 500;
            }
            if (i == 5) {
                for (int j = 0; j < zahl / 100; j++) roemischeZahl += "C";
                zahl %= 100;
            }
            if (i == 4) {
                for (int j = 0; j < zahl / 50; j++) roemischeZahl += "L";
                zahl %= 50;
            }
            if (i == 3) {
                for (int j = 0; j < zahl / 10; j++) roemischeZahl += "X";
                zahl %= 10;
            }
            if (i == 2) {
                for (int j = 0; j < zahl / 5; j++) roemischeZahl += "V";
                zahl %= 5;
            }
            if (i == 1) {
                for (int j = 0; j < zahl; j++) roemischeZahl += "I";
            }
        }

        return roemischeZahl;
    }
}