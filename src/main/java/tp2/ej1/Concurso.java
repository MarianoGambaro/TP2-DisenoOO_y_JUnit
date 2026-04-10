package tp2.ej1;

import tp2.ej3.Exportador;
import tp2.ej4.Notificador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private static int cont = 1;

    private int id;
    //private Exportador exportador;
    private Notificador notificador;
    private Exportador exportador;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> participantes;
    private List<Inscripcion> inscripciones;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Exportador exportador, Notificador notificador){
        this.notificador = notificador;
        this.exportador = exportador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
        this.id = cont;
        cont++;
    }


    public void inscribirParticipante(Participante participante, LocalDate fechaInscripcion){
        if(fechaInscripcion.isBefore(fechaInicio) || fechaInscripcion.isAfter(fechaFin)){
            throw new RuntimeException("La inscripcion esta fuera de la fecha permitida");
        }
        participantes.add(participante);
        if(fechaInscripcion.equals(fechaInicio)){
            participante.sumarPuntos(10);
        }
        Inscripcion inscripcion = new Inscripcion(participante, this, fechaInscripcion.atStartOfDay());
        inscripciones.add(inscripcion);
        exportador.exportarInsc(inscripcion);
        notificador.enviarInscripcion(participante.getMail());
    }


    public int cantidadInscriptos(){
        return inscripciones.size();
    }

    public boolean estaInscripto(Participante par) {
        return participantes.contains(par);
    }

    public boolean primerDiaInscripto(LocalDate fechaInscripcion){
        if(fechaInicio.equals(fechaInscripcion)){
            return true;
        }
        return false;
    }


    public int getId(){
        return id;
    }

}

