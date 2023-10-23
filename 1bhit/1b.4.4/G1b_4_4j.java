/**
 * Der Hamster dreht sich um.
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_4_4j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void umdrehen()
{
	linksUm();
	linksUm();
}

/**
 */
boolean vornKorn()
{
	boolean Korn = false;
	if (vornFrei() == true) {
		vor();
		if (kornDa() == true) Korn = true;
		umdrehen();
		vor();
		umdrehen();
	}
	return Korn;
}

/**
 */
int folgeKorn()
{
	int Steps = 0;
	boolean Tmp = true;
	while (kornDa() == true && vornFrei() == true && Tmp == true) {
		vor();
		if (kornDa() == true)
			++Steps;
		else { umdrehen(); vor(); umdrehen(); Tmp = false;}
	}
	return Steps;
}

/**
 */
public void main() {
	boolean TmpBool = false;
	for (int i=0; i<4; i++) {
		if (vornKorn() == true) {
			TmpBool = true;
			break;  // <== 'Ein Mal ist kein Mal!'
		}
		linksUm();
	}
	
	if (TmpBool == true) {
		int Steps = folgeKorn();
		schreib("Ich bin " + Steps + " Korn/Körnern gefolgt.");
	}
	else { schreib("Keine Spur gefunden."); }
}
}