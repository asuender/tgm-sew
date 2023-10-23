/**
 * Der Hamster schreibt den Text "Servas" auf das Territorium.
 * Folgende Methoden wurden von Andreas Suender geschrieben:
 	* gib12();
 	* schreibS(); [1]
 	* schreibE();
 	* schreibR();
 * Diese Methoden hat Noah Kurzmann übernommen.
 	* main();
 	* schreibV();
 	* schreibA();
 	* schreibS(); [2]
 * @author Andreas Suender; Noah Kurzmann
 * @version 2019-12-04
 */

/**
 * Der Hamster legt 12 Körner auf das aktuelle Feld.
 * Wird verwendet, um die Buchstaben zu schreiben.
 * @author Andreas Suender
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_3_3j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void gib12() {
	for (int i=0; i<12 && maulLeer() == false; i++) {
		gib();
	}
}

/**
 * Der Hamster schreibt den Buchstaben S.
 * Die gib12-Methode wird hierfür verwendet.
 * @author Andreas Suender
 */
void schreibS_asuender() {
	for (int i=0; i<2; i++) {
		for (int j=0; j<4; j++) {
			if (!(i == 0 && j == 0)) 
				gib12();
			vor();
		}
		
		if (i == 0) { linksUm(); linksUm(); }
	}
	
	linksUm();
	vor();
	
	for(int i=0; i<3; i++) {
		if (i == 0) {
			for (int j=0; j<2; j++) {
				gib12();
				vor();
			}
			linksUm();
			vor();
		}
		if (i == 1) {
			for (int j=0; j<3; j++) {
				gib12();
				vor();
			}
			linksUm();
			linksUm();
			linksUm();
			vor();
		}
		if (i == 2) {
			for (int j=0; j<2; j++) {
				gib12();
				vor();
			}
			linksUm();
			linksUm();
			linksUm();
			vor();
		}
	}
	
	for(int i=0; i<4; i++) {
		gib12();
		if (vornFrei() == true)
			vor();
	}
	
	//go to end position
	linksUm();
	linksUm();
	linksUm();
	
	while (vornFrei() == true)
		vor();
	
	linksUm();
	linksUm();
	linksUm();
	
	for (int i=0; i<4; i++)
		vor();
}

/**
 * Der Hamster schreibt den Buchstaben E.
 * Die gib12-Methode wird hierfür verwendet.
 * @author Andreas Suender
 */
void schreibE() {
	for (int i=0; i<4; i++) {
		if ((i == 0) || (i == 3)) {
			for (int j=0; j<5; j++) {
				gib12();
				vor();
			}
			
			linksUm();
			linksUm();
				
			for (int j=0; j<5; j++) 
				vor();	
		}
		
		if (i == 2) {
			linksUm();
			for (int j=0; j<6; j++) {
				vor();
				gib12();
			}
			linksUm();
		}
	}
	
	linksUm();
	linksUm();
	linksUm();
	
	for (int i=0; i<3; i++)
		vor();
	
	linksUm();
	linksUm();
	linksUm();
	
	for (int i=0; i<2; i++) {
		vor();
		gib12();
	}
	
	vor();
	vor();
	linksUm();
	
	for (int i=0; i<3; i++)
		vor();
		
	linksUm();
	linksUm();
	linksUm();
}

/**
 * Der Hamster schreibt den Buchstaben R.
 * Hierfür wird die gib12-Methode verwendet.
 * @author Andreas Suender
 */
void schreibR() {
	for (int i=0; i<4; i++) {
		int a = (i == 1 || i == 3) ? 2:4;
		for (int j=0; j<a; j++) {
			if (!(i == 3))
				gib12();
			vor();
		}
		linksUm();
		linksUm();
		linksUm();
		vor();
	}
	
	linksUm();
	linksUm();
	linksUm();
	
	for (int i=0; i<6; i++) {
		vor();
		if (kornDa() == false)
			gib12();
	}
	
	linksUm();
	
	for (int i=0; i<4; i++) {
		vor();
	}
	
	linksUm();
	
	for (int i=0; i<2; i++) {
		gib12();
		vor();
		linksUm();
		vor();
		gib12();
		linksUm();
		linksUm();
		linksUm();
	}
	
	for(int i=0; i<4; i++)
		vor();
	
	linksUm();
	linksUm();
	linksUm();
	
	vor();
	vor();
}

/**
 * Der Hamster schreibt denn Buchstaben V
 * Hierfür wird die gib12 Methode verwendet
 */
void schreibV() {
	linksUm();
	linksUm();
	linksUm();
	int felder;
	for(felder = 0; felder < 4; felder++) {
		gib12();
		vor();
	}
	gib12();
	linksUm();
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	gib12();
	vor();
	linksUm();
	vor();
	linksUm();
	gib12();
	vor();
	linksUm();
	linksUm();
	linksUm();
	vor();
	linksUm();
	gib12();
	vor();	
	linksUm();
	linksUm();
	linksUm();
	vor();
	gib12();
	linksUm();
	for(felder = 0; felder < 4; felder++) {
		if (vornFrei() == true)
			vor();
		gib12();
	}
	linksUm();
	linksUm();
	linksUm();
}
/**
 * Der Hamster schreibt denn Buchstaben A
 * Hierfür wird die gib12 Methode verwendet
 */
void schreibA() {
	int korn = 0;
	linksUm();
	linksUm();
	linksUm();
	while(korn < 6) {
		gib12();
		vor();
		korn++;
	}
	linksUm();
	linksUm();
	for(korn = 0; korn < 3; korn++) {
		gib12();
		vor();
	}
	linksUm();
	linksUm();
	linksUm();
	korn = 0;
	while(korn < 4) {
		gib12();
		vor();
		korn++;
	}
	linksUm();
	linksUm();
	linksUm();
	korn = 0;
	while(korn < 3) {
		gib12();
		vor();
		korn++;
	}
	linksUm();
	linksUm();
	korn = 0;
	for(;korn < 6; korn++) {
		gib12();
		vor();
	}
	linksUm();
	for(korn = 0; korn < 4; korn++) {
		gib12();
		vor();
	}
	linksUm();
	linksUm();
	korn = 0;
	while(korn < 4) {
		vor();
		korn++;
	}
}	
/**
 * Der Hamster schreibt denn Buchstaben S
 * Hierfür wird die gib12 Methode verwendet
 */
void schreibS_nkurzmann() {
	int leereFelder;
	for(leereFelder = 0; leereFelder < 4; leereFelder++) {
		vor();
		gib12();
	}
	linksUm();
	linksUm();
	for(leereFelder = 0; leereFelder < 4; leereFelder++) {
		vor();
	}
	linksUm();
	for(leereFelder = 0; leereFelder < 2; leereFelder++) {
		vor();
		gib12();
	}
	vor();
	linksUm();
	for(leereFelder = 0; leereFelder < 3; leereFelder++) {
		vor();
		gib12();
	}
	vor();
	linksUm();
	linksUm();
	linksUm();
	for(leereFelder = 0; leereFelder < 2; leereFelder++) {
		vor();
		gib12();
	}
	vor();
	linksUm();
	linksUm();
	linksUm();
	for(leereFelder = 0; leereFelder < 4; leereFelder++) {
		vor();
		gib12();
	}
	linksUm();
	linksUm();
	for(leereFelder = 0; leereFelder < 4; leereFelder++) {
		vor();
	}
	linksUm();
	for(leereFelder = 0; leereFelder < 6; leereFelder++) {
		vor();
	}
	linksUm();
	linksUm();
	linksUm();
	
	
}		

public void main() {
	schreibS_asuender();
	vor();
	vor();
	schreibE();
	vor();
	vor();
	schreibR();
	vor();
	vor();
	schreibV();
	vor();
	vor();
	schreibA();
	vor();
	vor();
	schreibS_nkurzmann();
}



}