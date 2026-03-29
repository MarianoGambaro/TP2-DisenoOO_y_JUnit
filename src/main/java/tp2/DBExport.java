package tp2;

public class DBExport implements Exportador{
    // Implementacion simulada de persistencia en base de datos.
    @Override
    public void exportar(String datos) {
        //
        System.out.println("Guardando en base de datos: " + datos);

    }
}
