package Entidades;

public class Persona {

    //Creo los atributos de la clase.
    private int idPersona;
    private String nombre;
    private double saldo;

    //Aquí pongo los contructores que me harán falta.
    public Persona() {  }
    public Persona(int idPersona, String nombre, double saldo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    //Aquí pongo los Getter y Setter.
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Sobreescribo el toString a mi gusto.
    @Override
    public String toString() {
        return String.format("ID: %d.  Nombre: %s.  Saldo: %.2f", idPersona, nombre, saldo);
    }
}
