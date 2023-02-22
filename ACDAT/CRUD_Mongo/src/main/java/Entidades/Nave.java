package Entidades;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Nave {

    //Variables de la clase
    private int _id;
    private String ganadero;
    private String ubicacion;
    private Timestamp fechaCreacionRegistro;
    //Constructores
    public Nave() {
    }
    public Nave(int _id, String ganadero, String ubicacion, Timestamp fechaCreacionRegistro) {
        this._id = _id;
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    public Nave(String ganadero, String ubicacion, Timestamp fechaCreacionRegistro) {
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //Getters y Setters
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
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
    public Timestamp getFechaCreacionRegistro() {
        return fechaCreacionRegistro;
    }
    public void setFechaCreacionRegistro(Timestamp fechaCreacionRegistro) {
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //toString
    @Override
    public String toString() {
        return String.format("idNave: %d, ganadero: %s, ubicación: %s" + System.lineSeparator()
            + "fecha última actualización: %s", _id, ganadero, ubicacion, new SimpleDateFormat("EEEE, dd-MMMM-yyyy, HH:mm:ss").format(fechaCreacionRegistro)
                + System.lineSeparator());
    }
}