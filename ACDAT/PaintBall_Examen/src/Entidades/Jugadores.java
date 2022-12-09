package Entidades;

public class Jugadores {

    //Atributos
    private int idJugador, numAciertos;
    private String nombre;

    //Constructores
    public Jugadores() {
    }
    public Jugadores(int idJugador, int numAciertos, String nombre) {
        this.idJugador = idJugador;
        this.numAciertos = numAciertos;
        this.nombre = nombre;
    }

    //Propiedades
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getNumAciertos() {
        return numAciertos;
    }

    public void setNumAciertos(int numAciertos) {
        this.numAciertos = numAciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Métodos
    @Override
    public String toString() {
        return "Jugadores{" +
                "idJugador=" + idJugador +
                ", numAciertos=" + numAciertos +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
