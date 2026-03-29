package tp2.ej2.tarjetas;

import tp2.ej2.Pedido;

public class TarjetaComarcaPlus implements Tarjeta{
    //Los pagos con tarjeta de crédito Comarca Plus tienen un
    //descuento del 2% sobre el costo total (bebidas + platos principales).
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.total() * 0.02;
    }
}
