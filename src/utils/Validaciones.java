package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.LocalDate;

public class Validaciones {
    
    private LocalDate llegada;
    private LocalDate salida;
    
    public void setDias(LocalDate llegada, LocalDate salida) {
        this.llegada = llegada;
        this.salida = salida;
    }
    
    public Long obtenerNoches() {
        return ChronoUnit.DAYS.between(llegada, salida);
    }
    
    public boolean validarFechas() {
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateLlegada = sdformat.parse(llegada.toString());
            Date dateSalida = sdformat.parse(salida.toString());
            return(dateLlegada.after(dateSalida) || dateLlegada.equals(dateSalida)) ? true : false;
        }  catch (ParseException ex) {
           System.out.println(ex.toString());
           return false;
        }
    }
    
    public boolean validarFechaLlegada() {
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateLlegada = sdformat.parse(llegada.toString());
            Date dateHoy = sdformat.parse(LocalDate.now().toString());
            return (!dateLlegada.after(dateHoy)) ? true : false;
        }  catch (ParseException ex) {
           System.out.println(ex.toString());
           return false;
        }
    }
}
