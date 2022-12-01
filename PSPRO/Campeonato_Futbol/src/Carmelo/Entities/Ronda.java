package Carmelo.Entities;

public class Ronda {

    private String equipoA;
    private String equipoB;
    private int golesA;
    private int golesB;

    public Ronda(String equipoA, String equipoB) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        golesA = 0;
        golesB = 0;
    }

    public String getEquipoA() {
        return equipoA;
    }

    public String getEquipoB() {
        return equipoB;
    }

    public int getGolesA() {
        return golesA;
    }

    public void setGolesA(int golesA) {
        this.golesA = golesA;
    }

    public int getGolesB() {
        return golesB;
    }

    public void setGolesB(int golesB) {
        this.golesB = golesB;
    }
}
