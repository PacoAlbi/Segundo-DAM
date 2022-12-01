package Carmelo.DAL;

import Carmelo.Entities.Equipo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorEquipos {

    MiConexion accesoDatos;


    public GestorEquipos() {
        this.accesoDatos = new MiConexion();

    }





    /**
     *
     * Método que se encarga de insertar un equipo en la base de datos seleccionada.
     * @param equipo objeto Equipo que se insertará en la base de datos.
     *
     * @return insertado: booleano que muestra si el objeto se insertó con éxito en la base de datos
     */
    public boolean InsertEquipo(Equipo equipo){
        var insertado = false;
        Connection cnn = null;
        try{

            cnn = accesoDatos.abrirConexion();
            var sql = String.format("Insert Into ad2223_caguilar.Equipos values%s", equipo.toString());
            Statement sttmnt = cnn.createStatement();
            sttmnt.executeUpdate(sql);
            insertado = true;

        } catch (SQLException e) {
            System.err.printf("Los datos que se introdujeron no eran correctos: %n %s %n", e.getMessage());
        }


        return insertado;
    }







    /**
     * Método que se encarga de eliminar un registro de la tabla Equipos base de datos
     * @param idEquipo nombre del equipo que se desea eliminar
     * @return eliminado -> booleano que muestra si el equipo se pudo eliminar de la base de datos
     */
    public boolean DeleteEquipo(String idEquipo){
        var eliminado = false;


        Connection cnn = null;
        try{
            cnn = accesoDatos.abrirConexion();

            var sql = String.format("Delete From ad2223_caguilar.Equipos Where idEquipo = '%s'", idEquipo);
            Statement sttmnt = cnn.createStatement();
            sttmnt.executeUpdate(sql);
            eliminado = true;

        } catch (SQLException e) {
            System.err.printf("No existe un Equipo con ese nombre en la base de datos: %n");
        }


        return eliminado;
    }


    /**
     * Método que se encarga de realizar la sentencia update en la tabla Equipos de la base de datos
     *
     * @param idEquipo El idEquipo de un objeto Equipo que concuerde con el campo idEquipo de la tabla Equipos
     * @param cantidad número que sumar a uno de los atributos de un objeto Equipo
     * @param atributo nombre del atributo tal como se nombra en la base de datos.
     *                  -perdidos, empatados, ganados, goles
     * @return
     */
    public boolean UpdateEquipo(String idEquipo, int cantidad, String atributo){
        var actualizado = false;

        Connection cnn = null;

        try{
            cnn = accesoDatos.abrirConexion();
            var sql = String.format("Update ad2223_caguilar.Equipos set %s = %d Where idEquipo = '%s'", atributo, cantidad, idEquipo);
            Statement sttmnt = cnn.createStatement();
            sttmnt.executeUpdate(sql);
            actualizado = true;
        } catch (SQLException e) {
            System.out.println("No se actualizaron los partidos ganados del equipo en la base de datos");

        }
        return actualizado;
    }




}
