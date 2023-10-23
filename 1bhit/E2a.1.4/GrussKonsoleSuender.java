/**
 * Erweitertes Programm.
 * Verdeutlicht die Verwendung von Kommandozeilenargumenten.
 * args[1] ist hierbei eines von den drei Werten (Morgen, Tag, Abend)
 * args[2] kann irgendein beliebiger Name sein.
 * @author Andreas Suender
 * @version 2019-02-15
 */

public class GrussKonsoleSuender {
	public static void main(String[] args) {
		String tagesZeit = args[0];
		String name = args[1];
		
		System.out.println("Guten " + tagesZeit + ", " + name + "!");
	}
}
