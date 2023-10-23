/**
 * Der Hamster zählt die Körner auf jedem Feld in einem einzeiligen Territorium
 * und berechnet anschließend den Durchschnitt.
 * @author Andreas Suender
 * @version 2019-11-18
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_2_4j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
	/* === Declarations === */
	double countSeed = 0.0;  //to count the seed
	double fields = 0.0;     //to count the fields
	double average;          //saves the average
	
	/* === count seed and fields === */
	for ( ; vornFrei() == true ; ) {
		fields += 1;
		
		//take every seed on each field
		for ( ; kornDa() == true ; ) {
			nimm();
			countSeed += 1.0;
		}
		//and go forward
		vor();
	}
	
	//also check the last field!
	while (kornDa() == true) {
		nimm();
		countSeed += 1.0;
	}
	
	/* === calculate average and print it out === */
	average = countSeed / fields;
	
	schreib("Durchschnitt: " + average + " Korn/Körner pro Feld.");
	
}
}