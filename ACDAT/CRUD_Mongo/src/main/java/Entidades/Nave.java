package Entidades;

import java.util.Date;

public class Nave {

    //Variables de la clase
    private String ganadero;
    private String ubicacion;
    private Date fechaCreacionRegistro;
    //Constructores
    public Nave() {
    }
    public Nave(String ganadero, String ubicacion, Date fechaCreacionRegistro) {
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //Getters y Setters
    public String getGanadero() {
        return ganadero;
    }
    public void setGanadero(String ganadero) {
        this.ganadero = ganadero;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Date getFechaCreacionRegistro() {
        return fechaCreacionRegistro;
    }
    public void setFechaCreacionRegistro(Date fechaCreacionRegistro) {
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //toString
    @Override
    public String toString() {
        return "Nave{" +
                "ganadero='" + ganadero + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaCreacionRegistro=" + fechaCreacionRegistro +
                '}';
    }
}