package tp2.ej2;

import tp2.Exportador;
import tp2.FileExport;
import tp2.ej2.tarjetas.TarjetaVisa;

public class Main {
    static void main() {

        Plato fideos = new Plato("Fideos con tuco", 16000);
        Plato hamburguesa = new Plato("Hamburguesa con papas", 18000);
        Bebida coca = new Bebida("Coca Cola", 2500);
        Bebida agua = new Bebida("Agua Mineral", 1800);

        ItemPedido item1 = new ItemPedido(fideos,2);
        ItemPedido item2 = new ItemPedido(hamburguesa,1);
        ItemPedido item3 = new ItemPedido(coca,2);
        ItemPedido item4 = new ItemPedido(agua,1);

        TarjetaVisa visa = new TarjetaVisa();

        Exportador exportador = new FileExport("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/-ticket.txt");

        Pedido p1 = new Pedido(exportador);
        p1.agregarItem(item1);
        p1.agregarItem(item2);
        p1.agregarItem(item3);
        p1.agregarItem(item4);

        p1.confirmarPedido();
        p1.calcularTotalFinal(visa,0.05);

        Ticket ticket = new Ticket(p1.calcularTotalFinal(visa,0.05));
        exportador.exportar(ticket.toString());
    }
}
