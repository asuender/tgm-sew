/**
 * EmailAnalyse
 * 
 * Diese Klasse enthält Methoden Isolieren vom Benutzer- bzw. Domainteil einer Email-Adresse.
 * @author Andreas Suender
 * @version 2020-05-11
 */
public class EmailAnalyse {

    /**
     * Diese Methode isoliert den Benutzerteil einer Email-Adresse und gibt diesen zurück.
     * @param addr Email-Adresse
     * @return Benutzerteil
     */
    public static String holeBenutzer(String addr) {
        return addr.substring(0, addr.indexOf('@'));
    }

    /**
     * Diese Methode isoliert den Domainteil einer Email-Adresse und gibt diesen zurück.
     * @param addr Email-Adresse
     * @return Domainteil
     */
    public static String holeDomain(String addr) {
        return addr.substring(addr.indexOf('@') + 1, addr.length());
    }

    /**
     * Diese Methode nimmt eine Email-Adresse auf ein Domain-Level als Zahl auf. Dann isoliert sie diesen
     * Teil vom Rest der Domain und gibt in zurück.
     * ANMERKUNG: Dies ist eigentlich schon das erweiterte (es geht auch mit mehr als 4 Levels) Programm, ich werde diesen Code sowohl GI als auch
     * EI abgeben.
     * @param addr Email-Adresse
     * @param level Domain-Level als Zahl
     * @return Isolierter Domain-Teil
     */
    // public static String holeDomainEbene(String addr, int level) {
    //     // Deklarationen der benötigten Variablen, nix besonderes
    //     int dotIndex = 0;
    //     int dotCount = 1;
    //     String res = "";

    //     // Hierfür ist es notwendig, nur den Domain-Teil der Adresse zu holen
    //     String domain = addr.substring(addr.indexOf('@') + 1, addr.length());

    //     // Hier wird gezählt, wie viele Levels es in der Domain gibt
    //     for (int j = 0; j < domain.length(); j++) {
    //         dotIndex = domain.indexOf('.', j);
    //         if (dotIndex != -1) {
    //             ++dotCount;
    //             j=dotIndex;
    //         }
    //     }

    //     // sollte der Benutzer eine ungültige Zahl eingeben, so wird das Ergebnis ein leerer String sein
    //     if (level > dotCount || level<1)
    //         res = "";
    //     else {
    //         dotIndex = 0;
    //         for (int i = 0; i < domain.length(); i++) {
    //             // Zähle die Levels ab bis das richtige gefunden worden ist
    //             dotIndex = domain.indexOf('.', i);
    //             if (dotIndex != -1) {
    //                 if (level == dotCount) {
    //                     res = domain.substring(i, dotIndex);
    //                     break;
    //                 }
    //                 --dotCount;
    //                 i=dotIndex;
    //             } else {
    //                 res = domain.substring(i, domain.length());
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }
    public static String holeDomainEbene(String addr,int ebene){
        String domain=addr.substring(addr.indexOf('@')+1);
        int index=0;
        for(int i=1;i<ebene;i++){
          index=domain.lastIndexOf('.');
          domain=domain.substring(0,index);
        }
        return domain.substring(domain.lastIndexOf('.')+1);
      }
}