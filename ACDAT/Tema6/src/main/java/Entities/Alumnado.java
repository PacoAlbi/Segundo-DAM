package Entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tAlumnado")
public class Alumnado implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idAlum")
    private int idAlumn;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ape1")
    private String ape1;
    @Column(name = "ape2")
    private String ape2;


    public Alumnado() {
    }

    public Alumnado(int idUsuario, String nombre, String ape1, String ape2) {
        this.idAlumn = idUsuario;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public Alumnado(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public int getIdAlumn() {
        return idAlumn;
    }

    public void setIdAlumn(int idAlumn) {
        this.idAlumn = idAlumn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    @Override
    public String toString() {
        return "Alumnado{" +
                "idAlumn=" + idAlumn +
                ", nombre='" + nombre + '\'' +
                ", ape1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                '}';
    }
}
