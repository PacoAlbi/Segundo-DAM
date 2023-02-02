package Vacas.Entities;

import jdk.jfr.Name;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VQ_Ganado")
@NamedQueries({
        @NamedQuery(name = "ListaVacas", query = "from VQ_Ganado a"),
        @NamedQuery(name = "TraerVaca", query = "from VQ_Ganado a where a.ID=:ID"),
        @NamedQuery(name = "ListarVacas", query = "from VQ_Ganado"),
        @NamedQuery(name = "MostrarVacasPorLugar", query = "from VQ_Ganado a where a.nave.ubicacion=:ubicacion"),
        @NamedQuery(name = "ListaHijas", query = "from VQ_Ganado a where a.id_madre.id=:ID"),
        @NamedQuery(name= "VacasDeAñoDeProduccion", query = "Select a.id, a.id_madre, a.hijas, a.fechaEntrada,a.fechaSacrificio, b.year_produccion from VQ_Ganado as a inner join VQ_Produccion as b on a.id=b.idVaca where b.year_produccion=:year"),
        @NamedQuery(name = "VacasDeNave", query = "from VQ_Ganado a where a.nave.id=:idnave"),
        @NamedQuery(name = "TotalVacasPorGanaderos", query = "select count (a)from VQ_Ganado a where a.nave.ganadero=:ganadero"),
        @NamedQuery(name = "VacasSinMadre", query = "from VQ_Ganado as a where a.id_madre is null"),
        @NamedQuery(name = "ContarVacasSinMadre", query = "select count(a) from VQ_Ganado as a where a.id_madre is null")

})
// insert into VQ_Ganado (ID, fechaEntrada, fechaSacrificio, nombre, idNave, id_madre) values (1, '2015-02-13', '2021-02-13', 'Orly', 2, null);
public class VQ_Ganado implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "fechaEntrada")
    private String fechaEntrada;

    @Column(name = "fechaSacrificio")
    private String fechaSacrificio;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_madre", referencedColumnName = "ID")
    private VQ_Ganado id_madre;


    @OneToMany(mappedBy = "id_madre")
    private List<VQ_Ganado> hijas;

    @ManyToOne
    @JoinColumn(name = "id_nave")
    //Column(name="id_nave")
    private VQ_Naves nave;

    @OneToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produccion")
    private List<VQ_Produccion> listaProducciones;

    public List<VQ_Ganado> getHijas() {
        return hijas;
    }

    public void setHijas(List<VQ_Ganado> hijas) {
        this.hijas = hijas;
    }

    public VQ_Naves getNave() {
        return nave;
    }

    public void setNave(VQ_Naves nave) {
        this.nave = nave;
    }

    public List<VQ_Produccion> getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(List<VQ_Produccion> listaProducciones) {
        this.listaProducciones = listaProducciones;
    }

    public VQ_Ganado getId_madre() {
        return id_madre;
    }

    public void setId_madre(VQ_Ganado id_madre) {
        this.id_madre = id_madre;
    }

/*


    @ManyToOne
    @JoinColumn(name = "idVaca")
    private VQ_Ganado madre;


    @OneToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_madre")
    private List<VQ_Ganado> listaVacasHijas;
*/

    public VQ_Ganado() {
    }

    public VQ_Ganado(int ID, String fechaEntrada, String fechaSacrificio, String nombre, int idnave, int idmadre, List<VQ_Produccion> listaProducciones) {
        this.ID = ID;
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;

        this.nave = new VQ_Naves();
        this.nave.setIdNave(idnave);
        if(idmadre >0){
            this.id_madre = new VQ_Ganado();
            this.id_madre.setID(idmadre);
        }
        else{
            this.id_madre = null;
        }
        this.listaProducciones = listaProducciones;

    }



    public VQ_Ganado(String fechaEntrada, String fechaSacrificio, String nombre, int idnave, int idmadre, List<VQ_Produccion> listaProducciones) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        if(idmadre >0){
            this.id_madre = new VQ_Ganado();
            this.id_madre.setID(idmadre);
        }
        else{
            this.id_madre = null;
        }
        this.nave = new VQ_Naves();
        this.nave.setIdNave(idnave);
        this.id_madre = new VQ_Ganado();
        this.id_madre.setID(idmadre);

        this.listaProducciones = listaProducciones;


    }
    public VQ_Ganado(String fechaEntrada, String fechaSacrificio, String nombre, int idnave, int idmadre) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        if(idmadre >0){
            this.id_madre = new VQ_Ganado();
            this.id_madre.setID(idmadre);
        }
        else{
            this.id_madre = null;
        }
        this.nave = new VQ_Naves();
        this.nave.setIdNave(idnave);
        this.id_madre = new VQ_Ganado();
        this.id_madre.setID(idmadre);

        this.listaProducciones = new ArrayList<VQ_Produccion>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSacrificio() {
        return fechaSacrificio;
    }

    public void setFechaSacrificio(String fechaSacrificio) {
        this.fechaSacrificio = fechaSacrificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    public VQ_Naves getIdNave() {
        return VQNaves;
    }

    public void setIdNave(VQ_Naves idVQNaves) {
        this.VQNaves = idVQNaves;
    }

    public VQ_Ganado getMadre() {
        return madre;
    }

    public void setIdMadre(VQ_Ganado madre) {
        this.madre = madre;
    }

    public List<VQ_Produccion> getListaProducciones (){
        return listaProducciones;
    }
    public void setListaProducciones (List<VQ_Produccion> listaProducciones){
        this.listaProducciones = listaProducciones;
    }
*/


    @Override
    public String toString() {
        return "VQ_Ganado{" +
                "idVaca=" + ID +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", fechaSacrificio='" + fechaSacrificio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id_nave=" + getNave().getIdNave() +
                ", id_madre=" + id_madre +
                '}';
    }
}
