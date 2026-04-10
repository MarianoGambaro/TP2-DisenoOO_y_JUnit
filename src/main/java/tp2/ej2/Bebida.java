package tp2.ej2;

public class Bebida extends Producto{

    public Bebida(String nombre, double precio){
        super(nombre, precio);
    }

    //cuando el objeto es bebida, calcula su subtotal. De lo contrario retorna 0
    @Override
    public double calcularSubtotalPlato(ItemPedido itemPedido) {
        return 0;
    }

    @Override
    public double calcularSubtotalBebida(ItemPedido itemPedido) {
        return itemPedido.calcularSubtotal();
    }


}
