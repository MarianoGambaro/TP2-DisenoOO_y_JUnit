package tp2.ej1;

import tp2.Exportador;
import tp2.FileExport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private static int cont = 1;

    private int id;
    private Exportador exportador;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> participantes;
    private List<Inscripcion> inscripciones;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Exportador exportador){
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
        Inscripcion insc = new Inscripcion(participante, this);
        participantes.add(participante);
        inscripciones.add(insc);

        exportador.exportar(insc.toString());

        if(fechaInscripcion.equals(fechaInicio)){
            participante.sumarPuntos(10);
        }
    }


    public int cantidadInscriptos(){
        return participantes.size();
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

    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        for(Inscripcion i : inscripciones){
            sb.append(i.toString());
        }
        return sb.toString();
    }

    public int getId(){
        return id;
    }

}

