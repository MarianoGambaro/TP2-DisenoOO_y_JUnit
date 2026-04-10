package ej5;

import tp2.ej1.Inscripcion;
import tp2.ej2.Ticket;
import tp2.ej3.Exportador;

public class FakeExportador implements Exportador {

    private int llamadasPago = 0;
    private int llamadasInsc;
    @Override
    public void exportarPago(Ticket ticket) {
        llamadasPago++;
    }

    @Override
    public void exportarInsc(Inscripcion datos) {
        llamadasInsc++;
    }

    public int getLlamadasPago(){
        return llamadasPago;
    }
    public int getLlamadasInsc(){
        return llamadasInsc;
    }
}
