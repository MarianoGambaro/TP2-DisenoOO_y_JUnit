package tp2.ej1;

public class Participante {
    private static int contador = 1;

    private int id;
    private String nombre;
    private int puntos;

    public Participante(String nombre) {
        this.id = contador;
        contador++;
        this.nombre = nombre;

    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getId() {
        return id;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }
}
