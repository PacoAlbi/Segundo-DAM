package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Ciudadania")
@NamedQueries({
        @NamedQuery(name = "RecuentoPasta", query = "select count(c.KG_pasta) from Ciudadania c where c.Pasta_favorita=:nombrePasta"),
})
public class Ciudadania implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @ManyToOne
    @JoinColumn(name = "ID_madre", referencedColumnName = "ID")
    private Ciudadania ID_madre;
    @ManyToOne
    @JoinColumn(name = "ID_padre", referencedColumnName = "ID")
    private Ciudadania ID_padre;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "Sexo")
    private char Sexo;
    @Column(name = "Fecha_nacimiento")
    private LocalDate Fecha_nacimiento;
    @Column(name = "Fecha_muerte")
    private LocalDate Fecha_muerte;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pasta_favorita")
    private Pastas Pasta_favorita;
    @Column(name = "KG_pasta")
    private int KG_pasta;

    //Constructores
    public Ciudadania() {
    }
    public Ciudadania(int ID, Ciudadania ID_madre, Ciudadania ID_padre, String nombre, String apellidos, char sexo, LocalDate fecha_nacimiento, LocalDate fecha_muerte, Pastas pasta_favorita, int KG_pasta) {
        this.ID = ID;
        this.ID_madre = ID_madre;
        this.ID_padre = ID_padre;
        this.nombre = nombre;
        this.apellidos = apellidos;
        Sexo = sexo;
        Fecha_nacimiento = fecha_nacimiento;
        Fecha_muerte = fecha_muerte;
        Pasta_favorita = pasta_favorita;
        this.KG_pasta = KG_pasta;
    }
    public Ciudadania(Ciudadania ID_madre, Ciudadania ID_padre, String nombre, String apellidos, char sexo, LocalDate fecha_nacimiento, LocalDate fecha_muerte, Pastas pasta_favorita, int KG_pasta) {
        this.ID_madre = ID_madre;
        this.ID_padre = ID_padre;
        this.nombre = nombre;
        this.apellidos = apellidos;
        Sexo = sexo;
        Fecha_nacimiento = fecha_nacimiento;
        Fecha_muerte = fecha_muerte;
        Pasta_favorita = pasta_favorita;
        this.KG_pasta = KG_pasta;
    }
    public Ciudadania(Ciudadania ID_madre, Ciudadania ID_padre, String nombre, String apellidos) {
        this.ID_madre = ID_madre;
        this.ID_padre = ID_padre;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public Ciudadania(int ID, LocalDate fecha_muerte) {
        this.ID = ID;
        Fecha_muerte = fecha_muerte;
    }

    //Getter y Setter
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public Ciudadania getID_madre() {
        return ID_madre;
    }
    public void setID_madre(Ciudadania ID_madre) {
        this.ID_madre = ID_madre;
    }
    public Ciudadania getID_padre() {
        return ID_padre;
    }
    public void setID_padre(Ciudadania ID_padre) {
        this.ID_padre = ID_padre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public char getSexo() {
        return Sexo;
    }
    public void setSexo(char sexo) {
        Sexo = sexo;
    }
    public LocalDate getFecha_nacimiento() {
        return Fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }
    public LocalDate getFecha_muerte() {
        return Fecha_muerte;
    }
    public void setFecha_muerte(LocalDate fecha_muerte) {
        Fecha_muerte = fecha_muerte;
    }
    public Pastas getPasta_favorita() {
        return Pasta_favorita;
    }
    public void setPasta_favorita(Pastas pasta_favorita) {
        Pasta_favorita = pasta_favorita;
    }
    public int getKG_pasta() {
        return KG_pasta;
    }
    public void setKG_pasta(int KG_pasta) {
        this.KG_pasta = KG_pasta;
    }

    //toString
    @Override
    public String toString() {
        return "Ciudadania{" +
                "ID=" + ID +
                ", ID_madre=" + ID_madre +
                ", ID_padre=" + ID_padre +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", Sexo=" + Sexo +
                ", Fecha_nacimiento=" + Fecha_nacimiento +
                ", Fecha_muerte=" + Fecha_muerte +
                ", Pasta_favorita=" + Pasta_favorita +
                ", KG_pasta=" + KG_pasta +
                '}';
    }
}
