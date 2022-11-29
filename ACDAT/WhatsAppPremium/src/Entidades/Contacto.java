package Entidades;

public class Contacto {

    //Atributos
    private String idContacto;
    private String nombre;
    private int bloqueado;

    //constructores
    public Contacto(String idContacto, String nombre) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.bloqueado = 0;
    }
    public Contacto(String idContacto){
        this.idContacto=idContacto;
        this.bloqueado = 0;
    }

    public Contacto() {}

    //Propiedades
    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        String estado = "desbloqueado";
        if (bloqueado == 1){
            estado = "bloqueado";
        }
        return String.format("Id: %s. El nombre del contacto es %s, y está %s",idContacto, nombre, estado);
    }
}
