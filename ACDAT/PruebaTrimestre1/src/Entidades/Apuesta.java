package Entidades;

public class Apuesta {

    //Creo los atributos de la clase.
    private int idApuesta, numSorteo, idPersona, numero;

    //Aquí pongo los contructores que me harán falta.
    public Apuesta() {
    }

    public Apuesta(int idApuesta, int numSorteo, int idPersona, int numero) {
        this.idApuesta = idApuesta;
        this.numSorteo = numSorteo;
        this.idPersona = idPersona;
        this.numero = numero;
    }

    //Aquí pongo los Getter y Setter.
    public int getIdApuesta() {
        return idApuesta;
    }

    public void setIdApuesta(int idApuesta) {
        this.idApuesta = idApuesta;
    }

    public int getNumSorteo() {
        return numSorteo;
    }

    public void setNumSorteo(int numSorteo) {
        this.numSorteo = numSorteo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Sobreescribo el toString a mi gusto.
    @Override
    public String toString() {
        return String.format("ID Apuesta: %d. Número del sorteo: %d. ID Persona: %d. Número al que apuesta: %d", idApuesta, numSorteo, idPersona, numero);
    }
}
