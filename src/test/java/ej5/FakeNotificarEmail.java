package ej5;

import tp2.ej4.Notificador;

public class FakeNotificarEmail implements Notificador {

    private String ultimoEmailEnviado;
    private int cantidadEnviados = 0;

    FakeNotificarEmail(){

    }
    @Override
    public void enviarInscripcion(String email) {
        ultimoEmailEnviado = email;
        cantidadEnviados ++;
    }

    public int getCantidadEnviados(){
        return cantidadEnviados;
    }
}
