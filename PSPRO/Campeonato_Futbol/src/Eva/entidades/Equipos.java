package Eva.entidades;

public class Equipos {

    private String idEquipo;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int golesMarcados;
    private int golesRecibidos;

    public Equipos(){

    }

    public Equipos(String idEquipo, int ganados, int empatados, int perdidos, int golesMarcados, int golesRecibidos) {
        this.idEquipo = idEquipo;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
        this.golesMarcados = golesMarcados;
        this.golesRecibidos = golesRecibidos;
    }
    public Equipos(String idEquipo) {
        this.idEquipo = idEquipo;
        this.ganados = 0;
        this.empatados = 0;
        this.perdidos = 0;
        this.golesMarcados = 0;
        this.golesRecibidos = 0;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    @Override
    public String toString() {
        return String.format("('%s', %d, %d, %d, %d, %d);", idEquipo, ganados, empatados, perdidos, golesMarcados, golesRecibidos);
    }

}
