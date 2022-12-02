package Entidades;

public class Sorteo {

    //Creo los atributos de la clase.
    private int numSorteo, num1, num2, num3;
    private double recaudacion, bote;

    //Aquí pongo los contructores que me harán falta.
    public Sorteo() { }

    public Sorteo(int numSorteo, int num1, int num2, int num3, double recaudacion, double bote) {
        this.numSorteo = numSorteo;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.recaudacion = recaudacion;
        this.bote = bote;
    }

    //Aquí pongo los Getter y Setter.
    public int getNumSorteo() {
        return numSorteo;
    }

    public void setNumSorteo(int numSorteo) {
        this.numSorteo = numSorteo;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    //Sobreescribo el toString a mi gusto.
    @Override
    public String toString() {
        return String.format("ID del sorteo: %d.  Recaudación: %.2f  Bote: %.2f" + System.lineSeparator()
                + "Números premiados: %d  %d  %d", numSorteo, recaudacion, bote, num1, num2, num3);
    }
}
