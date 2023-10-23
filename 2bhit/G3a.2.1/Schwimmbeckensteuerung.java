import java.util.Scanner;

/**
 * Diese Klasse testet die Klasse 'Schwimmbecken' und führt alle Methoden davon aus.
 * @version 2020-10-20
 * @author Andreas Suender
 */
public class Schwimmbeckensteuerung {
    /**
     * Kleine Hilfsmethode, um das erstellen eines Objekts zu vereinfach, der Code steht nicht in der main-Methode.
     * Ja, ich weiß, es ist komplett unnötig, aber dafür übersichtlich.
     * @param values String im Format l/b/h
     * @return Fertiges Schwimmbecken-Objekt
     */
    public static Schwimmbecken erstelleSchwimmbecken(String values) {
        int pos_slash_first  = values.indexOf('/');
        int pos_slash_second = values.substring(pos_slash_first+1).indexOf('/');
        
        // bissl gekürzt...
        return new Schwimmbecken(
            Integer.parseInt(values.substring(0, pos_slash_first)),
            Integer.parseInt(values.substring(pos_slash_first+1, pos_slash_first+pos_slash_second+1)),
            Integer.parseInt(values.substring(pos_slash_second+pos_slash_first+2))
        );
    }
    
    public static void main(String[] args) {
        // Ich verwende die Kommandozeile, JOptionPane ist hier nicht unbedingt nötig
        Scanner console = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie Maße für das Schwimmbecken im Format l/b/h ein: ");
        Schwimmbecken s = erstelleSchwimmbecken(console.nextLine());
        
        System.out.println("Bitte geben Sie die Füllmenge für das Schwimmbecken ein: ");
        s.setQuantity(Integer.parseInt(console.nextLine()));
        
        System.out.println("\nVolumen des Schwimmbeckens: "+s.volume()+" l");
        
        System.out.print("\nKontrolle der Maße:\n"+s.status()+"\nStimmen die Daten (true/false)? ");
        if ( "false".equals(console.nextLine()) ) {
            System.out.print("Bitte eine Länge eingeben: "); 
            s.setLength( Integer.parseInt(console.nextLine()) );
            
            System.out.print("Bitte eine Breite eingeben: "); 
            s.setWidth( Integer.parseInt(console.nextLine()) );
            
            System.out.print("Bitte eine Höhe eingeben: "); 
            s.setHeight( Integer.parseInt(console.nextLine()) );   
        }
        
        System.out.println("Daten übernommen.\nSoll etwas ins Becken eingefüllt oder aus dem Becken ausgeleert werden (1/2)?");
        switch( Integer.parseInt(console.nextLine()) ) {
            case 1:
                System.out.print("Wert: ");
                s.einfuellen(Integer.parseInt(console.nextLine()));
                break;
            case 2:
                System.out.print("Wert: ");
                s.auslassen(Integer.parseInt(console.nextLine()));
                break;
            default:
                s.leeren();
        }
        System.out.println("\n\nStatus:\n"+s.status());
        console.close();
    }
}
