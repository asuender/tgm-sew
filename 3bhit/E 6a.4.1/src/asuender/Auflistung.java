package asuender;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

/**
 * @author Andreas Suender
 * @version 05-12-2022
 */
public class Auflistung {
    /**
     * Gibt alle die Daten einer Datei bzw. aller Unterdateien (falls ein Ordner übergeben wird) aus. Diese Daten beinhalten
     * Name, Tag der letzten Änderung sowie die Größe in Bytes in genau dieser Reihenfolge, getrennt durch Bindestriche und ggf.
     * eingerückt.
     * @param file Fileobjekt, dessen Daten untersucht werden soll
     * @param ident Anzahl der Einrückungen (in Tabs)
     * @return Daten aller untersuchten Dateien
     * @throws NullPointerException falls ein Nullobjekt übergeben wird
     * @throws FileNotFoundException falls die Datei/der Ordner nicht gefunden wurde
     */
    public static String listFile(File file, int ident) throws NullPointerException, FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Die Datei ist ein Nullobjekt!");
        }

        if (!file.exists()) {
            throw new FileNotFoundException("Die Datei bzw. der Ordner existiert nicht!");
        }

        StringBuilder builder = new StringBuilder();
        builder.append("\t".repeat(ident));

        if (file.isFile()) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            builder.append(file.getName() + " - " + df.format(file.lastModified()) + " - " + file.length() + " Bytes");
        } else {
            builder.append("+ " + file.getName());
        }

        builder.append("\n");

        if (file.isDirectory()) {
            ++ident;
            for (File f : Objects.requireNonNull(file.listFiles())) {
                builder.append(listFile(f, ident));
            }
        }

        return builder.toString();
    }

    /**
     * Ruft {@link Auflistung#listFile(File, int)} mit keiner Einrückung (ident = 0) auf.
     * @param file Fileobjekt, dessen Daten untersucht werden soll
     * @return Daten aller untersuchten Dateien
     * @throws NullPointerException falls ein Nullobjekt übergeben wird
     * @throws FileNotFoundException falls die Datei/der Ordner nicht gefunden wurde
     */
    public static String listFile(File file) throws NullPointerException, FileNotFoundException {
        return listFile(file, 0);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(listFile(new File("C:\\Users\\andis\\Documents\\Bewerbungen")));

        // Wirfte eine FileNotFoundException
        // System.out.println(listFile(new File("C:\\Users\\andis\\Documents\\Existiert nicht")));
    }
}
