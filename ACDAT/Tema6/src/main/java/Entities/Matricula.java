package Entities;

import javax.persistence.*;

@Entity
@Table(name = "tMatricula")
@NamedQuery(name = "alumnadoMatricula", query = "select m from Matricula m where m.alumno.nombre =:nombre")
public class Matricula {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idMat")
    private int idMat;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlum")
    private Alumnado alumno;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAsig")
    private Asignaturas asignatura;

    public Matricula() {
    }

    public Matricula(int idMat, Alumnado alumno, Asignaturas asignatura) {
        this.idMat = idMat;
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    public Matricula(Alumnado alumno, Asignaturas asignatura) {
        this.alumno = alumno;
        this.asignatura = asignatura;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public Alumnado getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnado alumno) {
        this.alumno = alumno;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }
}
