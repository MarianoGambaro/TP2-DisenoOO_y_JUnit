package tp2.ej2;

import tp2.ej2.tarjetas.Tarjeta;
import tp2.ej3.Exportador;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;
    private boolean confirmado;
    private Exportador exportador;

    public Pedido(Exportador exportador){
        this.exportador = exportador;
        items = new ArrayList<ItemPedido>();
        confirmado = false;
    }

    public void agregarItem(ItemPedido item){
        validarPedidoEsEditable();
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
            totalBebidas += item.obtenerProducto().calcularSubtotalBebida(item);
        }
        return totalBebidas;
    }

    //valor total de platos
    public double calcularTotalPlatos(){
        double totalPlatos = 0;
        for(ItemPedido item : items){
            totalPlatos += item.obtenerProducto().calcularSubtotalPlato(item);
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
        validarPorcentajePropina(porcentajePropina);
        double totalBase = total();
        double descuento = tarjeta.calcularDescuento(this);
        double totalConDescuento = totalBase - descuento;
        double propina = totalConDescuento * porcentajePropina;

        double totalFinal = totalConDescuento + propina;
        Ticket ticket = new Ticket(totalFinal);
        exportador.exportarPago(ticket);

        return totalFinal;
        //ahora el metodo retorna un ticket para poder exportarse facilmente
    }


    //validacion del estado del pedido
    public void validarPedidoEsEditable(){
        if(confirmado){
            throw new RuntimeException("El pedido ya fue confirmado");
        }
    }

    //validacion de porcentaje de propina
    public void validarPorcentajePropina(double porcentaje){
        if(porcentaje != 0.02 && porcentaje != 0.03 && porcentaje != 0.05){
            throw new RuntimeException("Porcentaje de propina invalido");
        }
    }

    public int cantidadItems(){
        return items.size();
    }
}
