import Conxion.Conexion;
import Entities.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Conexion conexion = new Conexion();
        conexion.abrirConexion();
        Scanner scanner = new Scanner(System.in);
        Profesores alumno = new Profesores();
        System.out.println("Nombre:");
        alumno.setNombre(scanner.next());
        System.out.println("Ape1");
        alumno.setApe1(scanner.next());
        System.out.println("Ape2");
        alumno.setApe2(scanner.next());
        conexion.listarProfesorado();

        //conexion.guardar(alumno);
        conexion.cerrar();

    }

    @NamedQuery(
            name = "alumnadoMatriculado",
            query = "select m from AlumnadoEntity a JOIN a.listaAlumnadoMatricula m JOIN m.asignatura asig"
    )
    private static void listarMatriculas() throws Exception {
        instancia.abrir();
        List<MatriculaEntity> lista = instancia.listar("alumnadoMatriculado");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    lista.get(i).getAlumnado().getNombreCompleto() + " " +
                            lista.get(i).getAsignatura().getNombre()+" "+
                            lista.get(i).getAsignatura().getCurso()+"º"
            );
        }
        instancia.cerrar();
    }

    @NamedQuery(name = "numeroAlumnado", query = "select count(a) from AlumnadoEntity a")

    public long resultado(String namedQuery) {
        Query lista = sesion.getNamedQuery(namedQuery);
        return (long)lista.uniqueResult();
    }

    @NamedQuery(name="listaAsignaturasPrimero", query="from AsignaturaEntity a where a.curso=1")
    @NamedQuery(name="listaAsignaturasCurso", query="from AsignaturaEntity a where a.curso=:curso")

    @NamedQuery(name="listaAsignaturas", query="select a.nombre from AsignaturaEntity a")
    @NamedQuery(name="listaAsignaturas", query="from AsignaturaEntity a")
}
