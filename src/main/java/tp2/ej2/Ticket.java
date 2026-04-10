package tp2.ej2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//cree la clase ticket para exportar facilmente los datos solicitados
public class Ticket {
    private LocalDateTime fecha;
    private double monto;

    public Ticket(double monto){
        this.fecha = LocalDateTime.now();
        this.monto = monto;
    }

    //getters para la bd
    public LocalDateTime getFecha(){
        return fecha;
    }
    public double getMonto(){
        return monto;
    }

    public String toCSV() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " || " + monto + System.lineSeparator();
    }
}
