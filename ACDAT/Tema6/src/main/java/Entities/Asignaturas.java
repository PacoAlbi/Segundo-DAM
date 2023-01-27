package Entities;

import javax.persistence.*;

@Entity
@Table(name = "tAsignaturas")
public class Asignaturas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idAsig")
    private int idAsig;
    private int idProf;
    private String nombre;
    private int curso;
    private int horas;
}
