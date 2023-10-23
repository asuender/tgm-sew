/**
 * Der Hamster zählt die Körner am aktuellen Feld
 * und gibt die Anzahl zurück.
 * @return Anzahl der Körner
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_4_6j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {double koernerAmFeld() {
    // That one will be returned
    //  |  'Cause counting the seed without picking them isn't possible,
    //  v  that's the only way to get the number.
	double countSeed = 0;
	while (kornDa() == true) {
		nimm();
		countSeed++;
	}
	
	while (maulLeer() != true)    //you can leave the {} out here
		gib();
		
	return countSeed;
}

/**
 * Der Hamster errechnet ich den Durchschnitt durch zwei mitgegebene Parameter.
 * @param seed Anzahl der Körner
 * @param fields Anzahl der Felder
 * @return Durchschnitt
 */
double durchschnitt(double seed, double fields) { // <======================= +
	// This function is really simple                                         |
	//But pay attention at the parameters, they're double(s), not int! ====== +
	return (seed / fields);
}

/**
 * Der Hamster zählt die Körner auf jedem Feld in einem einzeiligen Territorium
 * und berechnet anschließend den Durchschnitt.
 * Es werden eiegene Methoden wie
 *     koernerAmFeld()
 *     durchschnitt()
 * verwendet.
 * @author Andreas Suender
 * @version 2019-12-17
 */
public void main() {
    // NOTE: all variables are double!
    // Otherwise the result of 'durchschnitt' function could be '0'
    // for example:
    //     average = 0.3
    //               ^ ^
    //               | |
    // result of     | + ----- this part would be left out
    // conversation -+
    // to int
    // =>  average = 0;
	double seedCount = 0.0;
	double fieldCount = 0.0;
	
	while (vornFrei() == true) {
		seedCount += koernerAmFeld();
		vor();
		fieldCount += 1.0;
	}
	
	// hof course check the last field
	if (kornDa() == true) {
		seedCount += koernerAmFeld();
		fieldCount += 1.0;
	}
	
	double average = durchschnitt(seedCount, fieldCount);
	schreib("Durchschnitt: " + average + " Korn/Körner pro Feld.");
	
}
}