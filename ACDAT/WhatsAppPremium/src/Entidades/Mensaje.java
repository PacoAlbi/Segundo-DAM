package Entidades;

import java.sql.Timestamp;
import java.time.Instant;

public class Mensaje {

    //Atributos
    private int idMensaje;
    private String Texto;
    private Timestamp FechaHora;
    private int Leido;
    private String idContacto;

    //Constructores

    public Mensaje(int idMensaje, String texto, Timestamp fechaHora, String idContacto) {

        this.idMensaje = idMensaje;
        Texto = texto;
        FechaHora = Timestamp.from(Instant.now());
        Leido = 0;
        this.idContacto = idContacto;
    }
    public Mensaje(String texto, String idContacto){
        Texto=texto;
        FechaHora = Timestamp.from(Instant.now());
        Leido = 0;
        this.idContacto = idContacto;
    }

    public Mensaje(String texto){
        Texto=texto;
        FechaHora = Timestamp.from(Instant.now());
        Leido = 0;
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

    public int getLeido() {
        return Leido;
    }

    public void setLeido(int leido) {
        Leido = leido;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public String toString() {
        //String visto = "\033[34;1m>\033[0m";
        String visto = "☻";
        if (Leido == 1){
            visto = "☺";
        }
        return String.format("\033[33;1m%s\033[0m" + System.lineSeparator() +
                "IdMensaje %d. Enviado el %s. %s" + System.lineSeparator() + "%s.", idContacto, idMensaje, FechaHora, visto, Texto);
    }
}