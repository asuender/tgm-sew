/**
 * Dieses Programm gibt eine Zeile mit Sternchen aus. Die Anzahl kann
 * in einer Variable festgelegt werden.
 * @author Andreas Sünder
 * @version 2020-02-15
 */

 public class Sternchen_Zeile {
    public static void main(String[] args) {
        int count = 9;

        for (int i=0; i<count-1; i++) System.out.print("*");
        
        System.out.println("*");
     }
 }