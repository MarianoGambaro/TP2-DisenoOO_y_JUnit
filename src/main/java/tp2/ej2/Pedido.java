package tp2.ej2;

import tp2.ej3.Exportador;
import tp2.FileExport;
import tp2.ej2.tarjetas.Tarjeta;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;
    private boolean confirmado;
    //private Exportador exportador;

    public Pedido(){
        items = new ArrayList<ItemPedido>();
        confirmado = false;
        //this.exportador = exportador;
    }

    public void agregarItem(ItemPedido item){
        validarPedidoEditable();
        items.add(item);
    }

    public void confirmarPedido(){
        if(items.isEmpty()){
            throw new RuntimeException("No se puede confirmar un pedido vacio");
        }
        confirmado = true;
    }

    public boolean estaConfirmado(){
        return confirmado;

    }

    //valor total de bebidas
    public double calcularTotalBebidas(){
        double totalBebidas = 0;
        for(ItemPedido item : items){
            totalBebidas += item.obtenerProducto().subtotalBebida(item.calcularSubtotal());
        }
        return totalBebidas;
    }

    //valor total de platos
    public double calcularTotalPlatos(){
        double totalPlatos = 0;
        for(ItemPedido item : items){
            totalPlatos += item.obtenerProducto().subtotalPlato(item.calcularSubtotal());
        }
        return totalPlatos;
    }

    //valor total de platos y bebidas sin descuento
    public double total(){
        return calcularTotalPlatos() + calcularTotalBebidas();
    }

    //calcular total con descuento y propina
    public double calcularTotalFinal(Tarjeta tarjeta, double porcentajePropina){
        if(!confirmado){
            throw new RuntimeException("El pedido debe estar confirmado");
        }
        validarPorcentaje(porcentajePropina);
        double totalBase = total();
        double descuento = tarjeta.calcularDescuento(this);
        double totalConDescuento = totalBase - descuento;
        double propina = totalConDescuento * porcentajePropina;

        double totalFinal = totalConDescuento + propina;


        //exportador.exportar(new Ticket(totalFinal).toString());
        //calculo el total final y luego lo exporto,
        // ya que la consigna pide exportar cada vez que se calcule el costo de una cena/almuerzo
        return totalFinal;
    }


    //validacion del estado del pedido
    public void validarPedidoEditable(){
        if(confirmado){
            throw new RuntimeException("El pedido ya fue confirmado");
        }
    }

    //validacion de porcentaje
    public void validarPorcentaje(double porcentaje){
        if(porcentaje != 0.02 && porcentaje != 0.03 && porcentaje != 0.05){
            throw new RuntimeException("Porcentaje de propina invalido");
        }
    }
}
