package DAO;

import Entidades.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBBDD {
    /**
     * Este main lo uso únicamente para generar la Base de Datos y rellenarla. Lo saco del principal por comodidad y limpieza mías. Descomentas y funciona perfectamente.
     */
    public static void main(String[] args) {
//        String[] camposPersonas = {"idPersona INT PRIMARY KEY AUTO_INCREMENT,", "nombre VARCHAR(25),", "saldo DECIMAL(10,2)"};
//        String[] camposSorteos = {"numSorteo INT PRIMARY KEY AUTO_INCREMENT,", "recaudacion DECIMAL(10,2),", "bote DECIMAL(10,2),", "num1 INT,", "num2 INT,", "num3 INT"};
//        String[] camposApuestas = {"idApuesta INT PRIMARY KEY AUTO_INCREMENT,", "numSorteo INT,", "idPersona INT,", "numero INT,", "FOREIGN KEY (numSorteo) REFERENCES Sorteos (numSorteo),", "FOREIGN KEY (idPersona) REFERENCES Personas (idPersona)"};
//        crearTabla("Personas", camposPersonas);
//        crearTabla("Sorteos", camposSorteos);
//        crearTabla("Apuestas", camposApuestas);
//        leerFichero();
//        ConexionBBDD.desconectarBBDD();
    }

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para crear las tablas en la BBDD que recibe el nombre de la tabla y un string con la definición de los campos a crear.
     * @param tabla String con el nombre de la tabla.
     * @param nombresCampos Array de String con los campos a insertar en la tabla.
     * Postcondiciones: Las tablas se crean en la BBDD.
     */
    public static void crearTabla(String tabla, String[] nombresCampos) {

        String create = "CREATE TABLE " + tabla + " (";
        Statement st;

        for (int i = 0; i < nombresCampos.length; i++) {
            create += nombresCampos[i];
        }
        create += ")";

        System.out.println(create);
        try {
            st = ConexionBBDD.conectar().createStatement();
            st.executeUpdate(create);
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError creando la tabla en la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Precondiciones: Debe estar el fichero en la ruta especificada correctamente.
     * Método para leer el fichero txt dado y sacar persona a persona para poder insertarla en la BBDD mediante otro método al que llamo dentro.
     * Postcondiciones: Se crea una nueva persona para insertarla en la tabla correspondiente.
     */
    public static void leerFichero () {
        FileReader fichero;
        BufferedReader br;
        String linea;
        Persona nuevaPersona;
        try {
            fichero = new FileReader("src/Resources/Personas.txt");
            br = new BufferedReader(fichero);
            while ((linea = br.readLine()) != null){
                nuevaPersona = new Persona();
                nuevaPersona.setNombre(linea);
                nuevaPersona.setSaldo(100);
                insertarPersona(nuevaPersona);
            }
        } catch (IOException e) {
            System.out.println("\033[31;1;4mError de lectura/escritura del fichero." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para insertar una persona en la BBDD mediante una sentencia ya preparada. Recibe la persona por parámetro.
     * @param personaAinsertar Persona para insertar en la BBDD.
     * Postcondiciones: Las personas se insertan en la BBDD.
     */
    public static void insertarPersona(Persona personaAinsertar){
        String sql = String.format("Insert Into Personas values ('%s', '%s', '%s')",personaAinsertar.getIdPersona(), personaAinsertar.getNombre(), personaAinsertar.getSaldo());
        try{
            Statement st = ConexionBBDD.conectar().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("\033[31;1;4mError insertando a las personas en la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para reiniciar el sorteo que vaciará las tablas para un nuevo sorteo.
     * @param tabla String con el nombre de la tabla a vaciar.
     * Postcondiciones: Las tablas (menos persona) se vacían de la BBDD.
     */
    public static void reiniciarSorteo (String tabla){
        String sql = String.format("SET FOREIGN_KEY_CHECKS = 0; TRUNCATE TABLE '%s'; SET FOREIGN_KEY_CHECKS = 1;", tabla);
        try{
            Statement st = ConexionBBDD.conectar().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("\033[31;1;4mError vaciando las tablas de la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }
}