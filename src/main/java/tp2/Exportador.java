package tp2;

//Se define la interfaz Exportador para desacoplar la logica de persistencia,
// permitiendo guardar los datos tanto en archivo como en base de datos
// mediante distintas implementaciones (polimorfismo).
public interface Exportador {
    public void exportar(String datos);
}
