package tp2.ej2.tarjetas;

import tp2.ej2.Pedido;

public interface Tarjeta {
    //Aplico polimorfismo
    double calcularDescuento(Pedido pedido);
}
