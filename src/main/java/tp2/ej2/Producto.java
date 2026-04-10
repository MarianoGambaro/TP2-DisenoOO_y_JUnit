package tp2.ej2;

public abstract class Producto {
    private String nombre;
    private double precio;

    public abstract double calcularSubtotalPlato(ItemPedido itemPedido);
    public abstract double calcularSubtotalBebida(ItemPedido itemPedido);

    public Producto(String nombre, double precio){
        validarPrecioMayorACero(precio);
        this.nombre = nombre;
        this.precio = precio;
    }
    private void validarPrecioMayorACero(double precio){
        if(precio <= 0){
            throw new RuntimeException("El precio debe ser mayor a cero");
        }
    }
    public double obtenerPrecio(){
        return precio;
    }

}

