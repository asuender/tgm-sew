/**
 * Der Hamster 'zeichnet' den Umfang von einem benutzerdefinierten Rechteck.
 * Die Methoden dafür wurden u.a. von 1b.3.5 hergenommen,
 * die Abgabe basiert auf 1b.1.7
 * @author Andreas Suender
 * @version 2019-12-05
 */
 
/**
 * Methode: nimmAnzahlKoerner
 * Der Hamster versucht, soviele Körner zu nehmen, wie ihm 'per Parameter' gesagt
 * wurde. Mögliche Fehler umgangen.
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class G1b_3_6j extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void nimmAnzahlKoerner(int seed) {
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

/**
 * Methode: legeRechteck
 * Der Hamster kalkuliert dementsprechend der Benutzereingabe, wie viele
 * Körner er für ein Rechteck braucht und 'zeichnet' eins.
 * Mögliche Fehler umgangen.
 * Hierfür wird die Methode legeAnzahlSchritte(); verwendet.
 */
void legeRechteck(int sizeX_user, int sizeY_user) {
	for (int i=0; i<4; i++) {
		if (i % 2 == 0)
			legeAnzahlSchritte(sizeX_user);
		else
			legeAnzahlSchritte(sizeY_user);
	
		linksUm();
		linksUm();
		linksUm();
	}
}

public void main() {  
    int sizeX = 0;
    int sizeX_user;
	int sizeY = 0;
	int sizeY_user;
	int seed = 0;
	
	/* === user imput: size of rectangle === */
	sizeX_user = liesZahl("Bitte Breite eingeben:");
	sizeY_user = liesZahl("Bitte Höhe eingeben:");
	
	/* === check the size of territory === */
	// [X]
	while(vornFrei() == true) {
		vor();
		sizeX++;
	}
	
	linksUm();
	linksUm();
	linksUm();
	
	// [Y]
	while(vornFrei() == true) {
		vor();
		sizeY++;
	}
	
	linksUm();
	linksUm();
	while(vornFrei() == true)
		vor();
	linksUm();
	while(vornFrei() == true)
		vor();
	linksUm();
	linksUm();
	
	/* === draw of rectangle wouldn't be possible if there's not enough space === */
	if (sizeX_user > sizeX) {
		sizeX_user = sizeX-1;
		schreib("Deine Breite ist zu groß, ich werde sie verkleinern.");
	}
	else
		sizeX_user-=1;
	
	if (sizeY_user > sizeY) {
		sizeY_user = sizeY;
		schreib("Deine Höhe ist zu groß, ich werde sie verkleinern.");
	}
	else
		sizeY_user-=1;
	
	/* === user input: seed === */
	seed = liesZahl("Wie viele Körner soll ich nehmen?");
	nimmAnzahlKoerner(seed);
		
	/* === draw of rectangle wouldn't be possible if there's not enough seed === */
	if (sizeX_user*2 + sizeY_user*2 > seed)
		schreib("Zu wenig Körner!\nDu hast eingegeben: "+seed+"\nDu brauchst: "+(sizeX_user*2 + sizeY_user*2)+"\nIch werde versuchen, mehr zu nehmen.");
	
	//try to pick up more
	while ((sizeX_user*2 + sizeY_user*2 > seed) && (kornDa() == true)) {
		nimm();
		seed++;
	}
	
	if (sizeX_user*2 + sizeY_user*2 > seed)
		schreib("Immer noch zu wenig Körner! Es liegen zu wenig hier.");
	
	else {
		/* === now draw the rectangle == */
		vor();
		legeRechteck(sizeX_user, sizeY_user);
	}
}
}