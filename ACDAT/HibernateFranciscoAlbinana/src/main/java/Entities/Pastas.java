package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Pastas")
public class Pastas implements Serializable {

    //Atributos
    @Id
    @Column(name = "NombrePasta")
    private String NombrePasta;

    //Constructores
    public Pastas( ) {
    }
    public Pastas(String nombrePasta) {
        NombrePasta = nombrePasta;
    }

    //Getter y Setter
    public String getNombrePasta() {
        return NombrePasta;
    }
    public void setNombrePasta(String nombrePasta) {
        NombrePasta = nombrePasta;
    }

    //toString
    @Override
    public String toString() {
        return String.format("Nombre de la pasta: %s", NombrePasta);
    }
}