package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tProfesores")
@NamedQueries({
        @NamedQuery(name = "listaDocente", query = "from Profesores p"),
        @NamedQuery(name = "listaPorNombre", query = "from Profesores p where p.nombre = :nombre")//Los dos puntos le digo que no es un campo, si no un parametro.
})
public class Profesores implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idProf")
    private int idProf;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ape1")
    private String ape1;
    @Column(name = "ape2")
    private String ape2;


    public Profesores() {
    }

    public Profesores(int idUsuario, String nombre, String ape1, String ape2) {
        this.idProf = idUsuario;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
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
        return "Profesores{" +
                "idProf=" + idProf +
                ", nombre='" + nombre + '\'' +
                ", ape1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                '}';
    }
}
