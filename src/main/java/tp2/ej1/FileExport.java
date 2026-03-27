package tp2.ej1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExport {
    private String path;

    public FileExport(String path){
        this.path = path;
    }

    void exportar(String datos) {
        File aFile = new File(path);
        try (FileWriter writer = new FileWriter(aFile, true)) { //append true para que no se pise cada inscripcion
            writer.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
