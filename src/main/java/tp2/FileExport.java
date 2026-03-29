package tp2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExport implements Exportador{
    private String path;

    public FileExport(String path) {
        this.path = path;
    }

    public void exportar(String datos) {
        File aFile = new File(path);
        try (FileWriter writer = new FileWriter(aFile, true)) { //append true para que no se pise cada pago
            writer.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}