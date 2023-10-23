import javax.swing.JOptionPane;

/**
 * Dieses Program benutzt alle Methoden der Klasse 'Ziffernanalyse', um
 * deren Zweck/Verwendung zu verdeutlichen.
 *
 * @author Andreas Sünder
 * @version 2020-09-15
 */
public class TextEingabe {
    public static void main(String[] args) {
        String input, choice, output="";
        int choice_num;
        
        input = JOptionPane.showInputDialog(null, "Bitte einen Text eingeben:");
        do {
            choice = JOptionPane.showInputDialog(null, "Ziffern \"zaehlen\" oder \"filtern\"?");
            if (choice.equals("zaehlen")) choice_num = 0;
            else if (choice.equals("filtern")) choice_num = 1;
            else { choice_num = 3; }
        }
        while (choice_num == 3);

        switch (choice_num) {
            case 0:
            	int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Welche Ziffer soll gezähtl werden? (-1 wenn alle gezählt werden sollen."));
            	if (num == -1)    	
        			output = Ziffernanalyse.ziffernZaehlen(input)+"";
        		else {
					output = num+" kommt im Text "+Ziffernanalyse.ziffernZaehlen(input, num)+"x vor.";
				}
        		break;
        	case 1:
        		output = Ziffernanalyse.ziffernFiltern(input);
        		break;  
        }
        JOptionPane.showMessageDialog(null, "Ihr Wunsch: "+choice+": "+output);
    }
}
