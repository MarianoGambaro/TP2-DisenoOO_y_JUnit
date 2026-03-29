package tp2.ej2.tarjetas;

import tp2.ej2.Pedido;

public class TarjetaVisa implements Tarjeta{
    //Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo
    //total de las bebidas
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularTotalBebidas() * 0.03;
        //retorna el valor que se le debe restar al total
    }
}