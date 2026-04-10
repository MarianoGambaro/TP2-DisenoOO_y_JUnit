package tp2.ej2;

public class Plato extends Producto{

    public Plato(String nombre, double precio){
        super(nombre,precio);
    }

    //cuando el objeto es plato, calcula su subtotal. De lo contrario retorna 0.
    @Override
    public double calcularSubtotalPlato(ItemPedido itemPedido) {
        return itemPedido.calcularSubtotal();
    }

    @Override
    public double calcularSubtotalBebida(ItemPedido itemPedido) {
        return 0;
    }
}

