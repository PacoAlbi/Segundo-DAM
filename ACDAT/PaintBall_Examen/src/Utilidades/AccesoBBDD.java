package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoBBDD {

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para acceder a las personas de la BBDD y mediante una lista, hacer el sorteo.
     * @return Una List con todas las personas de la BBDD.
     * Postcondiciones: No tiene.
     */
    public static List<Persona> obtenerPersonas () {
        Statement st;
        ResultSet rs;
        String SQL = "SELECT * FROM Personas";
        List<Persona> listaPersonas = new ArrayList<>();
        try{
            st = ConexionBBDD.conectar().createStatement();
            rs = st.executeQuery(SQL);
            while(rs.next()){
                Persona nuevaPersona = new Persona();
                nuevaPersona.setIdPersona(rs.getInt(1));
                nuevaPersona.setNombre(rs.getString(2));
                nuevaPersona.setSaldo(rs.getInt(3));
                listaPersonas.add(nuevaPersona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listaPersonas);
        return listaPersonas;
    }

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para insertar un sorteo en la BBDD mediante un parámetro sorteo que recibe.
     * @param sorteoAinsertar Sorteo para insertar.
     * Postcondiciones: El sorteo queda registrado en la BBDD.
     */
    public static void insertarSorteo (Sorteo sorteoAinsertar){
        String sql = String.format("Insert Into Sorteos values ('%d', '%.2f', '%.2f', '%d', '%d', '%d')", sorteoAinsertar.getNumSorteo(), sorteoAinsertar.getRecaudacion(), sorteoAinsertar.getBote(), sorteoAinsertar.getNum1(), sorteoAinsertar.getNum2(), sorteoAinsertar.getNum3());
        try{
            Statement st = ConexionBBDD.conectar().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("\033[31;1;4mError insertando el sorteo en la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Precondiciones: Debe haber una conexión estable a la BBDD.
     * Método para insertar una apuesta en la BBDD mediante un parámetro apuesta que recibe.
     * @param apuestaAinsertar Apuesta a insertar.
     * Postcondiciones: La apuesta queda registrada en la BBDD.
     */
    public static void insertarApuesta (Apuesta apuestaAinsertar){
        String sql = String.format("Insert Into Apuestas values ('%d', '%d', '%d', '%d')",apuestaAinsertar.getIdApuesta(), apuestaAinsertar.getNumSorteo(), apuestaAinsertar.getIdPersona(), apuestaAinsertar.getNumero());
        try{
            Statement st = ConexionBBDD.conectar().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("\033[31;1;4mError insertando la apuesta en la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }
}