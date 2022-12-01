package Examen.Carmelo;

public class clsLibro {
    private int id;
    private String nombre;



    public clsLibro(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public clsLibro(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return String.format("=================%n nombre: %s %n=================", nombre);
    }
}
