package tp2;

import tp2.ej1.Inscripcion;
import tp2.ej2.Ticket;
import tp2.ej3.Exportador;

import java.io.FileWriter;
import java.io.IOException;

public class FileExport implements Exportador {
    private String path;

    public FileExport(String path) {
        this.path = path;
    }


    @Override
    public void exportarPago(Ticket ticket) {
        escribir(ticket.toCSV());
    }

    @Override
    public void exportarInsc(Inscripcion insc) {
        escribir(insc.toCSV());
    }

    private void escribir(String datos) {
        try (FileWriter writer = new FileWriter(path, true)) { //append true para que no se pise cada pago
            writer.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}