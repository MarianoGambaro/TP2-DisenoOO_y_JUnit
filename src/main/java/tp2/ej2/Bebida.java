package tp2.ej2;

public class Bebida extends Producto{

    public Bebida(String nombre, double precio){
        super(nombre, precio);
    }

    //cuando el objeto es bebida, contiene el subtotal. De lo contrario retorna 0
    @Override
    public double subtotalPlato(double subtotal) {
        return 0;
    }

    @Override
    public double subtotalBebida(double subtotal) {
        return subtotal;
    }


}
