/**
 * Der Hamster geht einfach so weit vor, wie möglich.
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_4_2j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void vorSolangeMoeglich()
{
	while (vornFrei() == true)
		vor();
}

/**
 * Ähnlich wie obige Funktion. Zusatz: Schritte werden mitgezählt.
 * @return Anzahl der gezählten Schritte.
 */
int schritteBisZumRand()
{
	int stepsCount = 0;
	while (vornFrei() == true) {
		vor();
		++stepsCount; //short form of 'stepsCount += 1'
	}				  //use pre-increment operators, not post-!
	return stepsCount;
}

/**
 * Der Hamster soll herausfinden, wie lange sein Territorium ist.
 * Dazu werden die Methoden
 *     vorSolangeMoeglich()
 *     schritteBisZumRand()
 * verwendet.
 * Er kann dabei auf irgendeinem Feld stehen.
 * Um die Größe herauszufinden, versucht er zunächst, zur linken oberen Ecke zu gelangen, 
 * von dort aus zu messen.
 * @author Andreas Suender
 * @version 2020-01-01
 */
public void main() {
	// find top left corner
	linksUm();
	linksUm();
	vorSolangeMoeglich();
	linksUm();
	linksUm();
	linksUm();
	vorSolangeMoeglich();
	linksUm();
	linksUm();
	linksUm();
	
    int Width; // initialization here not necessary +
    int Height; // === >		                    |
 									//              |
    Width = schritteBisZumRand()+1;	// < ========== + would be done here
    linksUm();
    linksUm();
    linksUm();
    Height = schritteBisZumRand()+1; // pay attention at '+1'!
    
    /* Just code to come back */
    linksUm();
    linksUm();
    vorSolangeMoeglich();
    linksUm();
    vorSolangeMoeglich();
    linksUm();
    linksUm();
    
    /* Print here */
    schreib("Größe:\n  Breite: " + Width + " Feld(er); Höhe: " + Height + " Feld(er).");
}
}