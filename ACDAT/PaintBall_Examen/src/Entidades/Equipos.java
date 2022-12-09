package Entidades;

public class Equipos {

    //Atributos
    private int idPartida, idJugador, vidas;
    private String equipo;

    //Constructores
    public Equipos() {
    }
    public Equipos(int idPartida, int idJugador, int vidas, String equipo) {
        this.idPartida = idPartida;
        this.idJugador = idJugador;
        this.vidas = vidas;
        this.equipo = equipo;
    }

    //Propiedades
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    //Métodos
    @Override
    public String toString() {
        return "Equipos{" +
                "idPartida=" + idPartida +
                ", idJugador=" + idJugador +
                ", vidas=" + vidas +
                ", equipo='" + equipo + '\'' +
                '}';
    }
}
