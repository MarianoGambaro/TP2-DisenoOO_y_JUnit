package tp2.ej2.tarjetas;

import tp2.ej2.Pedido;

public class TarjetaViedma implements Tarjeta{
    //no tiene descuento
    @Override
    public double calcularDescuento(Pedido pedido) {
        return 0;
    }
}
