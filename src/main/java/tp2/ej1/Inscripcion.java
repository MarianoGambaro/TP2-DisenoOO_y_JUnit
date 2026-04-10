package tp2.ej1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Cree la clase inscripcion para representar cada inscripcion con su fecha, participante y concurso.
//Separando la responsabilidad de la clase concurso y facilitando la exportacion del archivo txt.
public class Inscripcion {
    private Participante participante;
    private LocalDateTime fechaInscripcion;
    private Concurso concurso;

    public Inscripcion(Participante participante, Concurso concurso, LocalDateTime fechaInscripcion){
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion =  fechaInscripcion;
    }

    //Getters para la bd
    public LocalDateTime getFechaInscripcion(){
        return fechaInscripcion;
    }
    public Participante getParticipante(){
        return participante;
    }
    public Concurso getConcurso(){
        return concurso;
    }

    public String toCSV() {
        return fechaInscripcion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "," +
                participante.getId() + "," +
                concurso.getId() +
                System.lineSeparator();
    }
}
