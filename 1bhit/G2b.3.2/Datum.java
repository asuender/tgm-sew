/**
 * Diese Klasse enthält Methoden zum Auftrennen eines Datums zu Tag, Monat und Jahr und zum Berechnen
 * des Wochentags.
 * @author Andreas Suender
 * @version 2020-04-30
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

    public static String wochentag(int day, int month, int year) {
        // Deklarationen
        String dayOfWeek = "";
        int a, b, c;

        // Hauptteil
        if (month<=2) {
            month+=10;
            --year;
        }
        else month-=2;

        a = year/100;
        b = year%100;
        c = (int) ((2.6*month-0.2+day+5*b/4-7*a/4)%7); // Diesen Teil konnte ich einen wenig kürzen
        if (c<0)
            c+=7;
        switch(c) {
            case 0:
                dayOfWeek="Sonntag";
                break;
            case 1:
                dayOfWeek="Montag";
                break;
            case 2:
                dayOfWeek="Dienstag";
                break;
            case 3:
                dayOfWeek="Mittwoch";
                break;
            case 4:
                dayOfWeek="Donnerstag";
                break;
            case 5:
                dayOfWeek="Freitag";
                break;
            case 6:
                dayOfWeek="Samstag";
                break;
            default:
                dayOfWeek="Fehler.";
        }

        return dayOfWeek;
    }
}