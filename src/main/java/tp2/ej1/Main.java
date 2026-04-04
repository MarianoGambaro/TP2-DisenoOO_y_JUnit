package tp2.ej1;

import tp2.FileExport;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FileExport export = new FileExport("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/-salida.txt");

        Participante p1 = new Participante("Carlos");
        Participante p2 = new Participante("Juana");
        Participante p3 = new Participante("Julian");
        Participante p4 = new Participante("Mariano");

        //antes le pasaba por parametro al export, ya que se tenia que imprimir automaticamente cuando se inscribia un participante
        //Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(5), export);
        /*
        concurso.inscribirParticipante(p1, LocalDate.now());
        concurso.inscribirParticipante(p2, LocalDate.now());
        concurso.inscribirParticipante(p3, LocalDate.now());
        concurso.inscribirParticipante(p4, LocalDate.now());*/
    }
}