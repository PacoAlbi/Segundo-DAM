package Dao;

import Conexion.Conexion;
import Utilidades.Utilidades;
import modelo.Contacto;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactosDAO {

    /**
     * <b>METODO PARA INSERTAR UN NUEVO CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones : la tabla Contacto debe de existir <br>
     * Postcondiciones : se inserta un contacto
     * @param contacto Recibe el contacto a registrar.
     */
    public void registrarContactoDAO (Contacto contacto){

        String instruccionSQL = "INSERT INTO ad2223_mlopez.Contactos VALUES (NULL,'" + contacto.getNombre() + "','" + contacto.isBloqueado() + "')";
        try{
            Statement st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>METODO PARA ELIMINAR UN CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones : la tabla Contacto debe de existir <br>
     * Postcondiciones : se elimina un contacto
     * @param IdContacto el Id del contacto a eliminar.
     */
    public void eliminarContactoDAO (String IdContacto) {
        String instruccionSQL = "DELETE FROM Contactos Where idContacto = " + IdContacto;
        try{
            Statement st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>METODO PARA BLOQUEAR UN CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones : la tabla Contacto debe de existir <br>
     * Postcondiciones : se bloquea un contacto
     * @param contacto Recibe el contacto a bloquear.
     */
    public void bloquearContactoDAO (Contacto contacto){

        Statement st;
        contacto.setBloqueado(1);
        String instruccionSQL = "UPDATE ad2223_" + contacto.getIdContacto() +".Contactos SET Bloqueado='"+ contacto.isBloqueado() +"'" + " WHERE idUsuario=" + contacto.getIdContacto();

        try {
            st = Conexion.conectarseUsuario(contacto.getIdContacto(), "1234").createStatement();
            st.execute(instruccionSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
