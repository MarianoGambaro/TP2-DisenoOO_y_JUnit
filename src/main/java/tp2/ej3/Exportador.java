package tp2.ej3;

import tp2.ej1.Inscripcion;
import tp2.ej2.Ticket;

//Se define la interfaz Exportador para desacoplar la logica de persistencia,
// permitiendo guardar los datos tanto en archivo como en base de datos
// mediante distintas implementaciones (polimorfismo).
public interface Exportador {
    public void exportarPago(Ticket ticket);
    public void exportarInsc(Inscripcion datos);
}
