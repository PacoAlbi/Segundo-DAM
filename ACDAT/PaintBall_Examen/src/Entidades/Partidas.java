package Entidades;

public class Partidas {

    //Atributos
    private int ipPartida, numSupervivientes;
    private String eqipoGanador;

    //Constructores
    public Partidas() {
    }
    public Partidas(int ipPartida, int numSupervivientes, String eqipoGanador) {
        this.ipPartida = ipPartida;
        this.numSupervivientes = numSupervivientes;
        this.eqipoGanador = eqipoGanador;
    }

    //Propiedades
    public int getIpPartida() {
        return ipPartida;
    }

    public void setIpPartida(int ipPartida) {
        this.ipPartida = ipPartida;
    }

    public int getNumSupervivientes() {
        return numSupervivientes;
    }

    public void setNumSupervivientes(int numSupervivientes) {
        this.numSupervivientes = numSupervivientes;
    }

    public String getEqipoGanador() {
        return eqipoGanador;
    }

    public void setEqipoGanador(String eqipoGanador) {
        this.eqipoGanador = eqipoGanador;
    }

    //Métodos
    @Override
    public String toString() {
        return "Partidas{" +
                "ipPartida=" + ipPartida +
                ", numSupervivientes=" + numSupervivientes +
                ", eqipoGanador='" + eqipoGanador + '\'' +
                '}';
    }
}
