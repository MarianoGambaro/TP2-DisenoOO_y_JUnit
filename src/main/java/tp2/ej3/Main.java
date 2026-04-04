package tp2.ej3;

import tp2.ej1.Concurso;
import tp2.ej1.Inscripcion;
import tp2.ej1.Participante;
import tp2.ej2.*;
import tp2.FileExport;
import tp2.ej2.tarjetas.TarjetaVisa;

import java.time.LocalDate;

public class Main {
    static void main(String[] args) {
        //-----------------------------------------------------------------------
        Participante p1 = new Participante("Carlos");
        Participante p2 = new Participante("Juana");
        Participante p3 = new Participante("Julian");
        Participante p4 = new Participante("Mariano");

        Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(5));

        concurso.inscribirParticipante(p1, LocalDate.now());
        concurso.inscribirParticipante(p2, LocalDate.now());
        concurso.inscribirParticipante(p3, LocalDate.now());
        concurso.inscribirParticipante(p4, LocalDate.now());

        Inscripcion insc = new Inscripcion(p1, concurso);
        Inscripcion insc2 = new Inscripcion(p2, concurso);
        Inscripcion insc3 = new Inscripcion(p3, concurso);
        Inscripcion insc4 = new Inscripcion(p4, concurso);

        //-----------------------------------------------------------------------
        Plato fideos = new Plato("Fideos con tuco", 16000);
        Plato hamburguesa = new Plato("Hamburguesa con papas", 18000);
        Bebida coca = new Bebida("Coca Cola", 2500);
        Bebida agua = new Bebida("Agua Mineral", 1800);

        ItemPedido item1 = new ItemPedido(fideos,2);
        ItemPedido item2 = new ItemPedido(hamburguesa,1);
        ItemPedido item3 = new ItemPedido(coca,2);
        ItemPedido item4 = new ItemPedido(agua,1);

        TarjetaVisa visa = new TarjetaVisa();

        Pedido pedido = new Pedido();
        pedido.agregarItem(item1);
        pedido.agregarItem(item2);
        pedido.agregarItem(item3);
        pedido.agregarItem(item4);

        pedido.confirmarPedido();
        pedido.calcularTotalFinal(visa,0.05);

        Ticket ticket = new Ticket(pedido.calcularTotalFinal(visa,0.05));
        //-------------------------------------------------------------------------------

        Exportador exportarFile = new FileExport("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/-salida.txt");
        Exportador exportarDB = new DBExport("jdbc:mysql://localhost:3306/tp_objetos", "root", "74631");

        exportarDB.exportarInsc(insc);
        exportarDB.exportarInsc(insc2);

        exportarDB.exportarPago(ticket);

        exportarFile.exportarPago(ticket);
        exportarFile.exportarInsc(insc);
    }
}
