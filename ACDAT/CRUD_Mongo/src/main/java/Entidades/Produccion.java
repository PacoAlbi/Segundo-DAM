package Entidades;

import java.util.Date;

public class Produccion {

    //Variables de la clase
    private int idVaca;
    private Date mesProduccion;
    private Date AnoProduccion;
    private int litros;
    private Date fechaCreacionRegistro;

    //Constructores
    public Produccion() {
    }
    public Produccion(int idVaca, Date mesProduccion, Date anoProduccion, int litros, Date fechaCreacionRegistro) {
        this.idVaca = idVaca;
        this.mesProduccion = mesProduccion;
        AnoProduccion = anoProduccion;
        this.litros = litros;
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }
    //Getters y Setters
    public int getIdVaca() {
        return idVaca;
    }
    public void setIdVaca(int idVaca) {
        this.idVaca = idVaca;
    }
    public Date getMesProduccion() {
        return mesProduccion;
    }
    public void setMesProduccion(Date mesProduccion) {
        this.mesProduccion = mesProduccion;
    }
    public Date getAnoProduccion() {
        return AnoProduccion;
    }
    public void setAnoProduccion(Date anoProduccion) {
        AnoProduccion = anoProduccion;
    }
    public int getLitros() {
        return litros;
    }
    public void setLitros(int litros) {
        this.litros = litros;
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
        return "Produccion{" +
                "idVaca=" + idVaca +
                ", mesProduccion=" + mesProduccion +
                ", AnoProduccion=" + AnoProduccion +
                ", litros=" + litros +
                ", fechaCreacionRegistro=" + fechaCreacionRegistro +
                '}';
    }
}