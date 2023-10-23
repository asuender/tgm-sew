/**
 * Roemer
 * 
 * Diese Klasse enthält eine Methode zum Umwandeln einer rmöschischen Zahl in eine dekadische Zahl.
 * @author Andreas Suender
 * @version 2020-05-07
 */
public class Roemer {

    /**
     * Diese Methode kann den String rz in eine dekadische Zahl umwandeln, wobei sie die I vor dem V vernachlässigt.
     * @param rz römische Zahl als String
     * @return dekadische Zahl
     */
    public static int reomer(String rz) {
        int res = 0;
        for (int i=0; i<rz.length(); i++) {
            switch(rz.charAt(i)) {
                case 'I':
                    res+=1;
                    break;
                case 'V':
                    res+=5;
                    break;
                case 'X':
                    res+=10;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'C':
                    res+=100;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'M':
                    res+=1000;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}