package tp2.ej3;

import tp2.FileExport;
import tp2.ej1.Concurso;
import tp2.ej1.Inscripcion;
import tp2.ej1.Participante;
import tp2.ej2.*;
import tp2.ej2.tarjetas.TarjetaVisa;
import tp2.ej4.Notificador;
import tp2.ej4.Mailtrap;

import java.time.LocalDate;

public class Main {
    static void main(String[] args) {

        Exportador exportarFile = new FileExport("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/-salida.txt");
        Exportador exportarDB = new DBExport("jdbc:mysql://localhost:3306/tp_objetos", "root", "");

        //-----------------------------------------------------------------------
        Participante p1 = new Participante("Carlos", "carilito@gmail.com");
        Participante p2 = new Participante("Juana", "juana@gmail.com");

        Notificador notificador = new Mailtrap("sandbox.smtp.mailtrap.io","","",2525);
        Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(5), exportarDB, notificador);

        concurso.inscribirParticipante(p1, LocalDate.now());
        //Inscripcion insc2 = concurso.inscribirParticipante(p2, LocalDate.now());

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

        Pedido pedido = new Pedido(exportarDB);
        pedido.agregarItem(item1);
        pedido.agregarItem(item2);
        pedido.agregarItem(item3);
        pedido.agregarItem(item4);

        pedido.confirmarPedido();

        pedido.calcularTotalFinal(visa,0.05);
        //-------------------------------------------------------------------------------


    }
}