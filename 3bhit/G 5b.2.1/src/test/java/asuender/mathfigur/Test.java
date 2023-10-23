package asuender.mathfigur;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Andreas Suender
 * @version 01-08-2022
 */
public class Test {
    static abstract class Abstrakt {
        public int a;
    }

    static class NichtAbstrakt extends Abstrakt {

    }

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("ABC.txt");
        new PrintWriter("");

        Abstrakt nichtabstrakt = new NichtAbstrakt();
    }
}
