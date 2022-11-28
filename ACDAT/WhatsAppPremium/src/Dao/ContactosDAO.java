package Dao;

import Conexion.Conexion;
import Entidades.Contacto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactosDAO {

    /**
     * <b>METODO PARA INSERTAR UN NUEVO CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Contacto debe de existir <br>
     * Postcondiciones: se inserta un contacto
     * @param contacto Recibe el contacto a registrar.
     */
    public void registrarContactoDAO (Contacto contacto){

        String instruccionSQL = "INSERT INTO ad2223_falbinana.Contactos VALUES ('" + contacto.getIdContacto() + "','" + contacto.getNombre() + "','" + contacto.isBloqueado() + "')";
        try{
            Statement st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);
            System.out.println("Contacto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("No se ha podido insertar el contacto.");
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>METODO PARA ELIMINAR UN CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Contacto debe de existir <br>
     * Postcondiciones: se elimina un contacto
     * @param IdContacto el Id del contacto a eliminar.
     */
    public void eliminarContactoDAO (String IdContacto) {
        String instruccionSQL = "DELETE FROM ad2223_falbinana.Contactos Where idContacto = '" + IdContacto + "'";
        try{
            Statement st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);
            System.out.println("Contacto borrado correctamente.");
        } catch (SQLException e) {
            System.out.println("No se ha podido borrar el contacto.");
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>METODO PARA BLOQUEAR UN CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Contacto debe de existir <br>
     * Postcondiciones: se bloquea un contacto
     * @param idContacto Recibe el contacto a bloquear.
     */
    public void bloquearContactoDAO (String idContacto){
        Statement st;
        String instruccionSQL = "UPDATE ad2223_falbinana.Contactos SET Bloqueado = 1 WHERE idContacto = '" + idContacto + "'";
        try {
            st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>METODO PARA DESBLOQUEAR UN CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Contacto debe de existir <br>
     * Postcondiciones: se desbloquea un contacto
     * @param idContacto Recibe el contacto a desbloquear.
     */
    public void desbloquearContactoDAO (String idContacto){
        Statement st;
        String instruccionSQL = "UPDATE ad2223_falbinana.Contactos SET Bloqueado = 0 WHERE idContacto = '" + idContacto + "'";
        try {
            st = Conexion.conectarse().createStatement();
            st.execute(instruccionSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>METODO PARA OBTENER UNA LISTA DE CONTACTOS DE LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Contacto debe de existir <br>
     * Postcondiciones: no tiene
     * @return obtienes una List de contactos de la base de datos
     */
    public List<Contacto> obtenerContactosDAO() {

        Statement statement;
        ResultSet rs;
        String instruccionSQL = "SELECT * FROM ad2223_falbinana.Contactos";
        List<Contacto> listaContactos = new ArrayList<>();
        try{
            statement = Conexion.conectarse().createStatement();
            rs = statement.executeQuery(instruccionSQL);
            while(rs.next()){
                Contacto contacto = new Contacto();
                contacto.setIdContacto(rs.getString(1));
                contacto.setNombre(rs.getString(2));
                contacto.setBloqueado(rs.getInt(3));
                listaContactos.add(contacto);
            }
            statement.close();
            rs.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaContactos;
    }

}
