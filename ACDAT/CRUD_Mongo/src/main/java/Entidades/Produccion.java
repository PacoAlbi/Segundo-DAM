package Entidades;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Produccion {

    //Variables de la clase
    private int idVaca;
    private int mesProduccion;
    private int AnoProduccion;
    private int litros;
    private Timestamp fechaCreacionRegistro;

    //Constructores
    public Produccion() {
    }
    public Produccion(int idVaca, int mesProduccion, int anoProduccion, int litros, Timestamp fechaCreacionRegistro) {
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
    public int getMesProduccion() {
        return mesProduccion;
    }
    public void setMesProduccion(int mesProduccion) {
        this.mesProduccion = mesProduccion;
    }
    public int getAnoProduccion() {
        return AnoProduccion;
    }
    public void setAnoProduccion(int anoProduccion) {
        AnoProduccion = anoProduccion;
    }
    public int getLitros() {
        return litros;
    }
    public void setLitros(int litros) {
        this.litros = litros;
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
        return String.format("idVaca: %d, litros: %d, año de producción, mes de producción: %d" + System.lineSeparator()
            + "fecha de creación del registro: %s", idVaca, litros, AnoProduccion, mesProduccion, new SimpleDateFormat("EEEE, dd-MMMM-yyyy, HH:mm:ss").format(fechaCreacionRegistro)
                + System.lineSeparator());
    }
}