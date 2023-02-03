package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Matrimonios")
@NamedQueries({
        @NamedQuery(name = "Divorcios", query = "select count(c.Fecha_fin) from Matrimonios c where =:nombrePasta"),
})
public class Matrimonios implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDConyuge1")
    private Ciudadania IDConyuge1;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDConyuge2")
    private Ciudadania IDConyuge2;
    @Column(name = "Fecha_matrimonio")
    private LocalDate Fecha_matrimonio;
    @Column(name = "Fecha_fin")
    private LocalDate Fecha_fin;

    //Constructores
    public Matrimonios() {
    }
    public Matrimonios(int ID, Ciudadania IDConyuge1, Ciudadania IDConyuge2, LocalDate fecha_matrimonio, LocalDate fecha_fin) {
        this.ID = ID;
        this.IDConyuge1 = IDConyuge1;
        this.IDConyuge2 = IDConyuge2;
        Fecha_matrimonio = fecha_matrimonio;
        Fecha_fin = fecha_fin;
    }
    public Matrimonios(Ciudadania IDConyuge1, Ciudadania IDConyuge2, LocalDate fecha_matrimonio, LocalDate fecha_fin) {
        this.IDConyuge1 = IDConyuge1;
        this.IDConyuge2 = IDConyuge2;
        Fecha_matrimonio = fecha_matrimonio;
        Fecha_fin = fecha_fin;
    }
    public Matrimonios(Ciudadania IDConyuge1, Ciudadania IDConyuge2, LocalDate fecha_matrimonio) {
        this.IDConyuge1 = IDConyuge1;
        this.IDConyuge2 = IDConyuge2;
        Fecha_matrimonio = fecha_matrimonio;
    }
    public Matrimonios(int ID, LocalDate fecha_fin) {
        this.ID = ID;
        Fecha_fin = fecha_fin;
    }

    //Getter y Setter
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public Ciudadania getIDConyuge1() {
        return IDConyuge1;
    }
    public void setIDConyuge1(Ciudadania IDConyuge1) {
        this.IDConyuge1 = IDConyuge1;
    }
    public Ciudadania getIDConyuge2() {
        return IDConyuge2;
    }
    public void setIDConyuge2(Ciudadania IDConyuge2) {
        this.IDConyuge2 = IDConyuge2;
    }
    public LocalDate getFecha_matrimonio() {
        return Fecha_matrimonio;
    }
    public void setFecha_matrimonio(LocalDate fecha_matrimonio) {
        Fecha_matrimonio = fecha_matrimonio;
    }
    public LocalDate getFecha_fin() {
        return Fecha_fin;
    }
    public void setFecha_fin(LocalDate fecha_fin) {
        Fecha_fin = fecha_fin;
    }

    //toString
    @Override
    public String toString() {
        return String.format("ID: %d, Conyuge 1: %s  Conyuge 2: %s, Fecha de matrimonio: %s, Fecha de divorcio: %s",ID, IDConyuge1, IDConyuge2, Fecha_matrimonio, Fecha_fin);
    }
}