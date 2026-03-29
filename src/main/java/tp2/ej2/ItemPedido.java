package tp2.ej2;

public class ItemPedido {
    private Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad) {
        verificarCantidad(cantidad);
        this.producto = producto;
        this.cantidad = cantidad;
    }

    private static void verificarCantidad(int cantidad) {
        if(cantidad <= 0) {
            throw new RuntimeException("Cantidad invalida");
        }
    }

    public Producto obtenerProducto(){
        return producto;
    }

    public double calcularSubtotal(){
        return producto.obtenerPrecio() * cantidad;
    }
}
