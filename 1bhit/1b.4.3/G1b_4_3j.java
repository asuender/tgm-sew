/** 
 * Diese Methode gibt 'true' zurück, wenn der Hamster kein Korn im Maul hat od.
 * wenn keines am aktuellen Feld liegt. Andernfalls wird 'false' zurückgegeben.
 * @return Logischer Wert, ob der Hamster ein Korn hat.
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_4_3j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean keinKorn()
{	
	// similiar to 'weiterSuchen()'
	if (maulLeer() == true && kornDa() == false)
		return true;
	return false;
}

/**
 * Diese Methode gibt 'true' zurück, wenn der Weg vorne frei ist und
 * wenn kein Korn am aktuellen Feld liegt.
 * @return Logischer Wert, ob weitergesucht werden soll.
 */
boolean weiterSuchen()
{	
	// quite an easy function, made it shorter.
	if (vornFrei() == true && kornDa() == false)
		return true;
	return false;
}

/**
 * Der Hamster geht solange vor, solange er kein Korn hat und der Weg vorne frei ist.
 */
void suchen()
{	// It is possible to write such a loop without 'continue':
	boolean Finish = false;
	while (Finish == false) {
		if (weiterSuchen() == false) //check status just in the headline of the 'if'
			Finish = true;
		else { vor(); }
    }
}

/**
 * Der Hamster checkt, ob ein Korn am Feld liegt oder er eines im Maul hat.
 * Ist dies erfolgreich, spuckt er 'Mahlzeit!' aus. Wenn nicht, sucht er solange,
 * bis er eines findet, unter Berücksichtigung der Größe des Territoriums.
 * Am Ende wird nochmal gecheckt und falls nötig 'Mahlzeit!' ausgegeben.
 */
public void main() {
	// this construction seems very silly, but is helpful.
	// if seed is in his mouth or at the first field, Java skips the first 'if' and
	// continues at the second which is made to check the mouth/field for seed after a search.
    if (keinKorn() == true) suchen();
    if (keinKorn() == false) schreib("Mahlzeit!");
}
}