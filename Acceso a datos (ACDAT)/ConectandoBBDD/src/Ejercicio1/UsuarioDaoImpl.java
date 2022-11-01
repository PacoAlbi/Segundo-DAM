package Ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements IUsuarioDao {

    @Override
    public boolean registrar(Usuario usuario) {
        boolean registrar = false;
        Connection con = null;
        Statement st = null;
        String sql = "INSERT INTO ad2223_falbinana.Usuarios VALUES (NULL," + usuario.getNombre() + "," + usuario.getApellidos() + "," +
                usuario.getUsername() + "," + usuario.getEmail() + "," + usuario.getPassword() + ")";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            registrar = true;
        } catch (SQLException e) {
            System.out.println("Error insertando el usuario en la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        return registrar;
    }

    @Override
    public List<Usuario> obtener() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM ad2223_falbinana.Usuarios ORDER BY id";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setUsername(rs.getString(4));
                usuario.setEmail(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error, usuario no encontrado." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
                if (con!=null){
                    con.close();
                }
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        return listaUsuarios;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        boolean actualizar = false;
        Connection con = null;
        Statement st = null;
        String sql="UPDATE ad2223_falbinana.Usuarios SET nombre='"+usuario.getNombre()+"', apellidos='"+usuario.getApellidos()+"', username='"+usuario.getUsername()
                +"', email='"+usuario.getEmail()+"', password='"+usuario.getPassword()+"'" +" WHERE id="+usuario.getId();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error actualizando el usuario de la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        boolean eliminar = false;
        Connection con = null;
        Statement st = null;
        String sql="DELETE FROM ad2223_falbinana.Usuarios WHERE ID=" + usuario.getId();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error eliminado al usuario de la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
                if (con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        return eliminar;
    }
}