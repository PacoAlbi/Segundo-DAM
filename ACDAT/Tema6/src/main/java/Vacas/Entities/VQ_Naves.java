package Vacas.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "VQ_Naves")
@NamedQueries({
        @NamedQuery(name = "listaNaves", query = "from VQ_Naves n"),
        @NamedQuery(name = "listarVacas", query = "from VQ_Ganado"),
        @NamedQuery(name = "listaHijas", query = "from VQ_Ganado a where a.id_madre.id=:ID")
})
public class VQ_Naves implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idNave;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private List<VQ_Ganado> listaVQGanados;

    @Column(name = "ganadero")
    private String ganadero;
    @Column(name = "ubicacion")
    private String ubicacion;

    //Constructores
    public VQ_Naves() {
    }

    public VQ_Naves(int idNave, List<VQ_Ganado> listaVQGanados, String ganadero, String ubicacion) {
        this.idNave = idNave;
        this.listaVQGanados = listaVQGanados;
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
    }

    public VQ_Naves(int idNave, String ganadero, String ubicacion) {
        this.idNave = idNave;
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
    }

    public VQ_Naves(String ganadero, String ubicacion) {
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
    }

    //Getter y Setter
    public int getIdNave() {
        return idNave;
    }

    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }

    public void setListaVacas(List<VQ_Ganado> listaVQGanados) {
        this.listaVQGanados = listaVQGanados;
    }

    public List<VQ_Ganado> getListaVacas() {
        return listaVQGanados;
    }



    public String getGanadero() {
        return ganadero;
    }

    public void setGanadero(String ganadero) {
        this.ganadero = ganadero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //toString
    @Override
    public String toString() {
        return String.format("ID nave: %d, Ganadero: %s, Ubicación %s", idNave, ganadero, ubicacion);
    }
}