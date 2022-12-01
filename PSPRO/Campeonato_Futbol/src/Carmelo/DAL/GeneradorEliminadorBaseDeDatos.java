package Carmelo.DAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneradorEliminadorBaseDeDatos {


    MiConexion accesoConexion;


    public GeneradorEliminadorBaseDeDatos() {
        accesoConexion = new MiConexion();
    }


    /**
     * @param nombreTabla define el nombre que tendrá la tabla que se va a insertar en la base de datos
     * @param propiedades -define los campos de la tabla que se insertará en la base de datos.
     *                    -Los campos de la tabla deben ser "nombreCampo tipo"
     *                    -En case de tener Foreign Key,  se necesita que, en las posiciones finales del aray se encuentre un String del tipo
     *                    "Foreign Key (nombreCampo) References nombreTabla(nombreCampo) On Update 'Mode' OnDelete 'Mode'"
     *                    -La Primary Key se definirá junto al campo correspondiente de la forma
     *                    "nombreCampo tipoCampo Primary Key AUTO_INCREMENT(Si se necesita)"
     *                    <p>
     *                    Ejemplo:
     *                    {"id int Primary Key AUTO_INCREMENT", "nombre varChar(50)", "apellidos varChar(50)", "fechaNacimiento Date", "antiguedad int","idDepartamento int, "Foreign Key (idDepartamento) References Departamentos(id) On Update Cascade On Delete Cascade"}
     */
    public void insertTable(String nombreTabla, String[] propiedades) {
        Connection cnn = null;
        StringBuilder peticion = new StringBuilder("CREATE TABLE ");
        //peticion.append(USER);
        peticion.append(".");
        peticion.append(nombreTabla);
        peticion.append(" (");
        for (int i = 0; i < propiedades.length; i++) {
            peticion.append(propiedades[i]);
            if (i < propiedades.length - 1) {
                peticion.append(",");
            }
        }
        peticion.append(");");
        try {
            cnn = accesoConexion.abrirConexion();
            Statement sttmt = cnn.createStatement();
            sttmt.executeUpdate(peticion.toString());
            System.out.println("Se generó la Tabla " + nombreTabla);
        } catch (SQLException e) {
            System.err.printf("No se pudo insertar tabla %s", e.getMessage());
        } finally {
            assert cnn != null;
            accesoConexion.cerrarConexion(cnn);
        }
    }


    /**
     * Descripcion:
     */
    public void insertAllTables() {
/*
        String[] tablaEquipos = new String[]{
                "idEquipo VARCHAR(25) Primary Key, ganados INT, empatados INT, perdidos INT, golesMarcados INT, golesRecibidos INT"
        };

        insertTable("Equipos", tablaEquipos);
        */


        String[] tablaOctavos = new String[]{
                "equipoA VARCHAR(25) Foreign Key References Equipos(idEquipo)", "equipoB VARCHAR(25) Foreign Key References Equipos(idEquipo)", "golesA INT", "golesB INT", "Primary Key(equipoA, equipoB)"
        };
        insertTable("Octavos", tablaOctavos);
        String[] tablaCuartos = new String[]{
                "equipoA VARCHAR(25) Foreign Key References Equipos(idEquipo)", "equipoB VARCHAR(25) Foreign Key References Equipos(idEquipo)", "golesA INT", "golesB INT", "Primary Key(equipoA, equipoB)"
        };
        insertTable("Ronda", tablaCuartos);
        String[] tablaSemis = new String[]{
                "equipoA VARCHAR(25) Foreign Key References Equipos(idEquipo)", "equipoB VARCHAR(25) Foreign Key References Equipos(idEquipo)", "golesA INT", "golesB INT", "Primary Key(equipoA, equipoB)"
        };
        insertTable("Semifinales", tablaSemis);
        String[] tablaFinal = new String[]{
                "equipoA VARCHAR(25) Foreign Key References Equipos(idEquipo)", "equipoB VARCHAR(25) Foreign Key References Equipos(idEquipo)", "golesA INT", "golesB INT", "Primary Key(equipoA, equipoB)"
        };
        insertTable("Final", tablaFinal);

    }

}