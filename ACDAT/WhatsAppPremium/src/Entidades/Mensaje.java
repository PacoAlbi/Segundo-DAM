package Entidades;

import java.sql.Timestamp;

public class Mensaje {

    //Atributos
    private int idMensaje;
    private String Texto;
    private Timestamp FechaHora;
    private boolean Leido;
    private int idContacto;

    //Constructores

    public Mensaje(int idMensaje, String texto, Timestamp fechaHora, boolean leido, int idContacto) {
        this.idMensaje = idMensaje;
        Texto = texto;
        FechaHora = fechaHora;
        Leido = leido;
        this.idContacto = idContacto;
    }

    public Mensaje() {
    }

    //Propiedades

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public Timestamp getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        FechaHora = fechaHora;
    }

    public boolean isLeido() {
        return Leido;
    }

    public void setLeido(boolean leido) {
        Leido = leido;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public String toString() {
        return Texto + "   " + FechaHora ;
    }
}
