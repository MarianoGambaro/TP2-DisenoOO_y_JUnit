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

    @Override
    public String toString() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " || " + monto + System.lineSeparator();
    }
}
