package tp2.ej2;

public class Plato extends Producto{

    public Plato(String nombre, double precio){
        super(nombre,precio);
    }

    //cuando el objeto es plato, contiene el subtotal. De lo contrario retorna 0.
    @Override
    public double subtotalPlato(double subtotal) {
        return subtotal;
    }

    @Override
    public double subtotalBebida(double subtotal) {
        return 0;
    }
}

