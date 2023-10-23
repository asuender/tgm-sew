/**
 * Diese Klasse enthält Methoden zum Auftrennen eines Datums zu Tag, Monat und Jahr.
 * @author Andreas Suender
 * @version 2020-04-16
 */
public class Datum {
    /**
     * Aus einem Datum 'date' wird der Tag herausgenommen und als Dezimalzahl zurückgegeben.
     * @param date Datums-String
     * @return Tag
     */
    public static int tag(String date) {
        int day;
        String day_s = "";
        int index;

        // Suche den ersten Punkt im Datum
        for (index=0; index<date.length(); index++)
            if (date.charAt(index) == '.')
                break;
        
        // Hole den Tag
        for (int i=0; i<index; i++)
            day_s+=date.charAt(i);
        
        day = Integer.parseInt(day_s);
        return day;
    }

    /**
     * Aus einem Datum 'date' wird der Monat herausgenommen und als Dezimalzahl zurückgegeben.
     * @param date Datums-String
     * @return Monat
     */
    public static int monat(String date) {
        int month;
        String month_s = "";
        int posDayPoint   = 0;
        int posMonthPoint = 0;

        // Suche den ersten und zweiten Punkt im Datum
        for (int i=0; i<date.length(); i++) {
            if (date.charAt(i) == '.' && posDayPoint!=0) {
                posMonthPoint=i;
                break;
            }
            else if (date.charAt(i) == '.' && posDayPoint==0) 
                posDayPoint=i;
        }

        // Hole den Monat
        for (int i=posDayPoint+1; i<posMonthPoint; i++)
            month_s+=date.charAt(i);

        month = Integer.parseInt(month_s);
        return month;
    }

    /**
     * Aus einem Datum 'date' wird das Jahr herausgenommen und als Dezimalzahl zurückgegeben.
     * @param date Datums-String
     * @return Jahr
     */
    public static int jahr(String date) {
        int year;
        String year_s = "";
        int posYearPoint  = 0;
        int remFirstPoint = 0;

        // Suche den letzten Punkt im Datum
        for (int i=0; i<date.length(); i++) {
            if (date.charAt(i) == '.' && remFirstPoint != 0) {
                posYearPoint=i;
                break;
            }
            else if (date.charAt(i) == '.' && remFirstPoint == 0)
                remFirstPoint=i;
        }

        // Hole das Jahr
        for (int i=posYearPoint+1; i<date.length(); i++)
            year_s+=date.charAt(i);
        
        year = Integer.parseInt(year_s);
        return year;
    }
}