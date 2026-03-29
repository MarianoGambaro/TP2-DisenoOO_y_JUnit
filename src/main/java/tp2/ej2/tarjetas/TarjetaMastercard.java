package tp2.ej2.tarjetas;

import tp2.ej2.Pedido;

public class TarjetaMastercard implements Tarjeta{
    // Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre
    //el costo total de los platos principales.
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularTotalPlatos() * 0.02;
    }
}
