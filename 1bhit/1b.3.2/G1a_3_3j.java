/**
 * Der Hamster schreibt "Auf ins Abenteuer", geht soweit
 * vor wie möglich, sammelt am Ende alle Körner ein,
 * geht die selbe Strecke wieder zurück und legt alle
 * Körner ab. Abschließend wird der Text
 * "Endlich wieder zu Hause" ausgegeben.
 * ACHTUNG: Hier werden schon eingene Funktionen verwendet! Laut Angabe von 1b3.2
 * @author Andreas Suender
 * @version 2019-12-02
 */
/**
 * Der Hamster dreht um
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1a_3_3j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void umdrehen() {
	linksUm();
	linksUm();
} 

/**
 * Der Hamster soll soweit vorgehen, wie möglich.
 */
void vorGehen() {
	while (vornFrei() == true) {
		vor();
	}
}

/**
 * Der Hamster nimmt so viele Körner, wie am aktuellen Feld liegen.
 */
void koernerNehmen() {
	while (kornDa() == true) {
		nimm();
	}
}

/**
 * Der Hamster gibt so viele Körner ab, wie er im Maul hat.
 */
void koernerGeben() {
	while (!(maulLeer() == true)) {
		gib();
	}
}

public void main() {
	schreib("Auf ins Abenteuer");
	//soweit wie möglich vorgehen
	vorGehen();
	//bis das Feld leer ist Körner aufsammeln
	koernerNehmen();
	//umdrehen
	umdrehen();
	//Wieder ganz zurück gehen
	vorGehen();
	//Bis das Maul leer ist Körner ablegen
	koernerGeben();
	schreib("Endlich wieder zu Hause!");
	//Ende
}
}