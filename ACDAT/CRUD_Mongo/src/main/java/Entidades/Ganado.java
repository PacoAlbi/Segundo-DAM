package Entidades;

import java.sql.Timestamp;
import java.util.Date;

public class Ganado {

    //Variables de la clase
    private Date fechaEntrada;
    private Date fechaSacrificio;
    private String nombre;
    private int idNave;
    private int idMadre;
    private Timestamp fechaCreacionRegistro;
    //Constructores
    public Ganado() {
    }
    public Ganado(Date fechaEntrada, Date fechaSacrificio, String nombre, int idNave, int idMadre, Timestamp fechaCreacionRegistro) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        this.idNave = idNave;
        this.idMadre = idMadre;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //Getters y Setters
    public Date getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSacrificio() {
        return fechaSacrificio;
    }
    public void setFechaSacrificio(Date fechaSacrificio) {
        this.fechaSacrificio = fechaSacrificio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdNave() {
        return idNave;
    }
    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }
    public int getIdMadre() {
        return idMadre;
    }
    public void setIdMadre(int idMadre) {
        this.idMadre = idMadre;
    }
    public Timestamp getFechaCreacionRegistro() {
        return fechaCreacionRegistro;
    }
    public void setFechaCreacionRegistro(Timestamp fechaCreacionRegistro) {
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //toString
    @Override
    public String toString() {
        return "Ganado{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSacrificio=" + fechaSacrificio +
                ", nombre='" + nombre + '\'' +
                ", idNave=" + idNave +
                ", idMadre=" + idMadre +
                ", fechaCreacionRegistro=" + fechaCreacionRegistro +
                '}';
    }
}