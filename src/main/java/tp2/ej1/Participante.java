package tp2.ej1;

import java.util.Objects;

public class Participante {
    private static int contador = 1;

    private int id;
    private String nombre;
    private int puntos;
    private String mail;

    public Participante(String nombre, String mail) {
        this.id = contador;
        contador++;
        this.nombre = nombre;
        this.mail = mail;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public String getMail(){
        return mail;
    }

    public int getId() {
        return id;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
