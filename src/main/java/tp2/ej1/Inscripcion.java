package tp2.ej1;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
//Cree la clase inscripcion para representar cada inscripcion con su fecha, participante y concurso.
//Separando la responsabilidad de la clase concurso y facilitando la exportacion del archivo txt.
public class Inscripcion {
    private Participante participante;
    private LocalDateTime fecha;
    private Concurso concurso;

    public Inscripcion(Participante participante, Concurso concurso){
        this.participante = participante;
        this.concurso = concurso;
        fecha =  LocalDateTime.now();
    }

    //Getters para la bd
    public LocalDateTime getFecha(){
        return fecha;
    }
    public Participante getParticipante(){
        return participante;
    }
    public Concurso getConcurso(){
        return concurso;
    }

    @Override
    public String toString() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", " + participante.getId() +
                ", " + concurso.getId()+
                System.lineSeparator();
    }
}
