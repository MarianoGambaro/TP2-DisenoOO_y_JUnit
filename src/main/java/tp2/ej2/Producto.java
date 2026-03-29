package tp2.ej2;

public abstract class Producto {
    private String nombre;
    private double precio;

    public abstract double subtotalPlato(double subtotal);
    public abstract double subtotalBebida(double subtotal);

    public Producto(String nombre, double precio){
        validarPrecio(precio);
        this.nombre = nombre;
        this.precio = precio;
    }
    private void validarPrecio(double precio){
        if(precio <= 0){
            throw new RuntimeException("El precio debe ser mayor a cero");
        }
    }
    public double obtenerPrecio(){
        return precio;
    }

}

