package ej5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp2.ej1.Concurso;
import tp2.ej1.Inscripcion;
import tp2.ej1.Participante;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {
    private Concurso concurso;
    private FakeNotificarEmail fakeNotificador;
    private FakeExportador fakeExport;
    private Participante participante;
    private LocalDate hoy;

    @BeforeEach
    void setUp(){
        fakeNotificador = new FakeNotificarEmail();
        fakeExport = new FakeExportador();
        hoy = LocalDate.now();
        participante = new Participante("Carlos", "carlos@gmail.com");
        concurso = new Concurso(hoy, hoy.plusDays(5), fakeExport,fakeNotificador);

    }

    @Test
    //1-Un participante se inscribe en un concurso
    public void inscribiendoParticipante(){
        //ejecucion
        concurso.inscribirParticipante(participante,hoy);

        //verificacion
        assertTrue(concurso.estaInscripto(participante)); //chequear estos metodos
        assertEquals(1, concurso.cantidadInscriptos());
        assertEquals(1, fakeNotificador.getCantidadEnviados());
        assertEquals(1, fakeExport.getLlamadasInsc());
    }

    @Test
    //2- Un participante se inscribe en un concurso el primer dia abierta la inscripcion
    public void inscriptoPrimerDia(){
        //ejecucion
        concurso.inscribirParticipante(participante,hoy);


        //verificacion
        assertTrue(concurso.primerDiaInscripto(hoy));
        assertEquals(10,participante.getPuntos());
        assertEquals(1, fakeNotificador.getCantidadEnviados());
        assertEquals(1, fakeExport.getLlamadasInsc());
    }

    @Test
    //3- Un participante intenta inscribirse fuera del rango de inscripcion
    public void inscripcionFallidaFueraDeRango(){
        //ejecucion y verificacion
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante, hoy.plusDays(6));
        });
        assertEquals(0, fakeNotificador.getCantidadEnviados() );
        assertEquals(0, fakeExport.getLlamadasInsc());
    }

    //opcion false del metodo primerDiaInscripto
    @Test
    public void primerDiaNoInscripto() {
        //ejecucion
        concurso.inscribirParticipante(participante, hoy.plusDays(1));

        //verificacion
        assertFalse(concurso.primerDiaInscripto(hoy.plusDays(1)));
        assertEquals(0, participante.getPuntos());
        assertEquals(1, fakeNotificador.getCantidadEnviados());
        assertEquals(1, fakeExport.getLlamadasInsc());
    }
}