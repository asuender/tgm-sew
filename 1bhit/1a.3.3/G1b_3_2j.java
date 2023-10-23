/**
 * Der Hamster schreibt "Auf ins Abenteuer", geht soweit
 * vor wie möglich, sammelt am Ende alle Körner ein,
 * geht die selbe Strecke wieder zurück und legt alle
 * Körner ab. Abschließend wird der Text
 * "Endlich wieder zu Hause" ausgegeben.
 * @author Andreas Suender
 * @version 2019-10-07
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_3_2j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	schreib("Auf ins Abenteuer");
	//soweit wie möglich vorgehen
	while (vornFrei() == true) {
		vor();
	}
	//bis das Feld leer ist Körner aufsammeln (insgesamt 7)
	while(kornDa() == true) {
		nimm();
	}
	linksUm();
	linksUm();
	//Wieder ganz zurück gehen
	while(vornFrei() == true) {
		vor();
	}
	//Bis das Maul leer ist Körner ablegen (alle 7)
	while(maulLeer() == false) {
		gib();
	}
	schreib("Endlich wieder zu Hause!");
	//Ende
}
}