package Eva.entidades;

public class Campeonato {

    Equipos equipoA;
    Equipos equipoB;
    int golesA;
    int golesB;

    public Campeonato() {
    }

    public Campeonato(Equipos equipoA, Equipos equipoB, int golesA, int golesB) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.golesA = golesA;
        this.golesB = golesB;
    }

    public Equipos getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipos equipoA) {
        this.equipoA = equipoA;
    }

    public Equipos getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipos equipoB) {
        this.equipoB = equipoB;
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


