package Vacas.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VQ_produccion")
@NamedQueries({
        @NamedQuery(name = "NumeroLitrosAnual", query = "select sum(a.litros) from VQ_Produccion as a where a.year_produccion=:ANHO"),
        @NamedQuery(name = "NumeroLitrosMesYAnno", query = "Select sum(a.litros) from VQ_Produccion as a where a.mes_produccion=:MES and a.year_produccion=:ANIO"),
        @NamedQuery(name = "ProduccionesLitrosAnual", query = " from VQ_Produccion as a where a.year_produccion=:ANHO order by a.year_produccion"),
        @NamedQuery(name = "ProduccionLitrosMes", query = "from VQ_Produccion as a where a.mes_produccion=:MES order by a.year_produccion asc, a.mes_produccion asc")
})
public class VQ_Produccion implements Serializable {

    @Id
    @Column(name = "mes_produccion")
    private int mes_produccion;

    @Column(name = "litros")
    private int litros;

    @Id
    @Column(name = "year_produccion")
    private int year_produccion;

    /*
    @Id
    @ManyToOne
    @JoinColumn(name = "idVaca")
    private VQ_Ganado VQGanado;

     */
    @Id
    @Column(name = "idVaca")
    private int idVaca;
    
    public VQ_Produccion(){

    }

    public VQ_Produccion(int mes_produccion, int litros, int year_produccion, int VQGanado) {
        this.mes_produccion = mes_produccion;
        this.litros = litros;
        this.year_produccion = year_produccion;
        this.idVaca = VQGanado;
    }

    @Override
    public String toString() {
        return String.format("año produccion: %d, mes produccion: %s, litros producidos: %d, id de la VQ_Ganado: %d",year_produccion, mes_produccion, litros, idVaca);
    }

    public int getMes_produccion() {
        return mes_produccion;
    }

    public void setMes_produccion(int mes_produccion) {
        this.mes_produccion = mes_produccion;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getYear_produccion() {
        return year_produccion;
    }

    public void setYear_produccion(int year_produccion) {
        this.year_produccion = year_produccion;
    }

    public int getVQGanado() {
        return idVaca;
    }

    public void setVQGanado(int VQGanado) {
        this.idVaca = VQGanado;
    }
}
