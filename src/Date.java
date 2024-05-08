import java.util.*;
public class Date {
   int day;
   int month;
    int year;

    public String getDateh() {
        return dateh;
    }
    private String dateh;
    static Calendar Hora=Calendar.getInstance();
    static Calendar Fecha=Calendar.getInstance();
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDate() {
        int hora, minuto, segundo, dia, mes, anualidad;
        String fecha, horaA;
        hora = Hora.get(Calendar.HOUR_OF_DAY);
        minuto = Hora.get(Calendar.MINUTE);
        segundo = Hora.get(Calendar.SECOND);
        dia = Fecha.get(Calendar.DATE);
        mes = Fecha.get(Calendar.MONTH);
        anualidad = Fecha.get(Calendar.YEAR);
        fecha = "Date: " + dia + "/" + mes + "/" + anualidad;
        horaA = "\tHour: " + hora + ":" + minuto + ":" + segundo;
        this.dateh= fecha+horaA;
    }

}
