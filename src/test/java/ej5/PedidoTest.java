package ej5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp2.ej2.Bebida;
import tp2.ej2.ItemPedido;
import tp2.ej2.Pedido;
import tp2.ej2.Plato;
import tp2.ej2.tarjetas.TarjetaComarcaPlus;
import tp2.ej2.tarjetas.TarjetaMastercard;
import tp2.ej2.tarjetas.TarjetaViedma;
import tp2.ej2.tarjetas.TarjetaVisa;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    private Pedido pedido;
    private Plato fideos;
    private Plato hamburguesa;
    private Bebida coca;
    private Bebida agua;

    private ItemPedido item1;
    private ItemPedido item2;
    private ItemPedido item3;
    private ItemPedido item4;

    private FakeExportador fakeExport;

    @BeforeEach
    void setUp() {
        fakeExport = new FakeExportador();

        fideos = new Plato("Fideos con tuco", 16000);
        hamburguesa = new Plato("Hamburguesa con papas", 18000);
        coca = new Bebida("Coca Cola", 2500);
        agua = new Bebida("Agua Mineral", 1800);

        item1 = new ItemPedido(fideos, 2);
        item2 = new ItemPedido(hamburguesa, 1);
        item3 = new ItemPedido(coca, 2);
        item4 = new ItemPedido(agua, 1);

        pedido = new Pedido(fakeExport);

        pedido.agregarItem(item1);
        pedido.agregarItem(item2);
        pedido.agregarItem(item3);
        pedido.agregarItem(item4);
    }

    @Test
    void calcularTotalFinalConMastercard() {
        //set up
        TarjetaMastercard masterCard = new TarjetaMastercard();
        //ejec
        pedido.confirmarPedido();
        //verificacion
        assertEquals(56916.0, pedido.calcularTotalFinal(masterCard, 0.02));
        assertEquals(1, fakeExport.getLlamadasPago());
    }


    @Test
    void calcularTotalFinalConVisa(){
        TarjetaVisa visa = new TarjetaVisa();

        pedido.confirmarPedido();

        assertEquals(59425.8, pedido.calcularTotalFinal(visa, 0.05));
        assertEquals(1, fakeExport.getLlamadasPago());
    }

    @Test
    void calcularTotalFinalConComarcaPlus() {
        TarjetaComarcaPlus comarcaPlus = new TarjetaComarcaPlus();

        pedido.confirmarPedido();

        assertEquals(57333.92, pedido.calcularTotalFinal(comarcaPlus, 0.03));
        assertEquals(1, fakeExport.getLlamadasPago());
    }

    @Test
    void calcularTotalFinalConViedma() {
        TarjetaViedma viedma = new TarjetaViedma();

        pedido.confirmarPedido();

        assertEquals(57936.0, pedido.calcularTotalFinal(viedma, 0.02));
        assertEquals(1, fakeExport.getLlamadasPago());
    }

    @Test
    void agregarItemAPedidoConfirmado(){
        pedido.confirmarPedido();
        //ejecucion y verificacion
        assertThrows(RuntimeException.class, () -> {
            pedido.agregarItem(item2);
        });
        assertEquals(4, pedido.cantidadItems());
        assertEquals(0, fakeExport.getLlamadasPago());
    }

    @Test
    void confirmarPedidoVacio(){
        //setup
        Pedido p = new Pedido(fakeExport);
        //ejec y validacion
        assertThrows(RuntimeException.class, p::confirmarPedido);
        assertEquals(0,fakeExport.getLlamadasPago());
    }

    @Test
    void calcularTotalFinalAPedidoSinConfirmar(){
        //set up
        Pedido p = new Pedido(fakeExport);
        TarjetaViedma tarjeta = new TarjetaViedma();

        //ejecucion y verificacion
        assertThrows(RuntimeException.class,()->{
            p.calcularTotalFinal(tarjeta,0.02);
        });
        assertEquals(0, fakeExport.getLlamadasPago());
    }

    @Test
    void calcularTotalFinalSinPropina(){
        //set up
        TarjetaViedma tarjeta = new TarjetaViedma();

        //ejecucion
        pedido.confirmarPedido();

        //verificacion
        assertThrows(RuntimeException.class, ()->{
            pedido.calcularTotalFinal(tarjeta,0);
        });
        assertEquals(0, fakeExport.getLlamadasPago());
    }
}