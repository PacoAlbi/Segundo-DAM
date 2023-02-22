package Entidades;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ganado {

    //Variables de la clase
    private int _id;
    private Date fechaEntrada;
    private Date fechaSacrificio;
    private String nombre;
    private int idNave;
    private int idMadre;
    private Timestamp fechaCreacionRegistro;
    //Constructores
    public Ganado() {
    }
    public Ganado(int _id, Date fechaEntrada, Date fechaSacrificio, String nombre, int idNave, int idMadre, Timestamp fechaCreacionRegistro) {
        this._id = _id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        this.idNave = idNave;
        this.idMadre = idMadre;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    public Ganado(Date fechaEntrada, String nombre, int idNave, int idMadre, Timestamp fechaCreacionRegistro) {
        this.fechaEntrada = fechaEntrada;
        this.nombre = nombre;
        this.idNave = idNave;
        this.idMadre = idMadre;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //Getters y Setters
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
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
        String vaca;
        if (fechaSacrificio==null){
            vaca = String.format("idVaca: %d, nombre: %s, fecha de entrada: %s" + System.lineSeparator()
                            + "idNave: %d, idMadre: %d, fecha última actualización: %s", _id, nombre, new SimpleDateFormat("EEEE, dd-MMMM-yyyy").format(fechaEntrada),
                            idNave, idMadre, new SimpleDateFormat("EEEE, dd-MMMM-yyyy, HH:mm:ss").format(fechaCreacionRegistro) + System.lineSeparator());
        } else {
            vaca = String.format("idVaca: %d, nombre: %s, fecha de entrada: %s, fecha de sacrificio: %s" + System.lineSeparator()
                            + "idNave: %d, idMadre: %d, fecha última actualización: %s", _id, nombre, new SimpleDateFormat("EEEE, dd-MMMM-yyyy").format(fechaEntrada),
                            new SimpleDateFormat("EEEE, dd-MMMM-yyyy").format(fechaSacrificio), idNave, idMadre,
                            new SimpleDateFormat("EEEE, dd-MMMM-yyyy, HH:mm:ss").format(fechaCreacionRegistro) + System.lineSeparator());
        }
        return vaca;
    }
}