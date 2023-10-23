/**
 * Der Hamster soll eine bestimmte Anzahl an Körner nehmen und wieder hinlegen.
 * Gelöst wird dies durch zwei Methoden (nimmAnzahlKoerner und legeAnzahlSchritte)
 * @author Andreas Suender
 * @version 2019-12-04
 */
 
/**
 * Methode: nimmAnzahlKoerner
 * Der Hamster versucht, soviele Körner zu nehmen, wie ihm 'per Parameter' gesagt
 * wurde. Mögliche Fehler umgangen.
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_3_5j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void nimmAnzahlKoerner(int seed) {
	//count variable to count the placed seed
	int count = 0;
	
	//take as much seed as possible, but less than SEED-parameter
	while (kornDa() == true && count < seed) {
		nimm();
		count++;
	}
}
/**
 * Methode: legeAnzahlSchritte
 * Der Hamster geht so viele Schritte, wie ihm 'per Parameter' gesagt wurde
 * und legt auf jedes Feld ein Korn. Mögliche Fehler umgangen.
 */		
void legeAnzahlSchritte(int steps) {
	//count variable to count the steps
	int count = 0;
	
	//go forward as much as possible (but less than STEPS-paramter,
	//and try to give seed at every place
	while ((vornFrei() == true) && (count < steps)) {
		if (maulLeer() == false)
			gib();	
		vor();
		count++;
	}
}

public void main() {
    nimmAnzahlKoerner(liesZahl("Wie viele Körner soll ich aufheben?"));
    legeAnzahlSchritte(liesZahl("Wie viele Schritte soll ich gehen?"));
}
}