package Usuario;

import Controles.Conexion;
import Ejercicio1.IUsuarioDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public static boolean registrar(Usuario usuario) {
        boolean registrar = false;
        Connection con;
        Statement st = null;
        String sql = "INSERT INTO Usuarios VALUES (NULL,'" + usuario.getNombre() + "','" + usuario.getApellidos() + "','" +
                usuario.getUsername() + "','" + usuario.getEmail() + "','" + usuario.getPassword() + "')";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Usuario insertado correctamente.");
            registrar = true;
        } catch (SQLException e) {
            System.out.println("Error insertando el usuario en la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        Conexion.desconectarBBDD();
        return registrar;
    }

    public static List<Usuario> obtener() {
        Connection con;
        Statement st = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios ORDER BY id";
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
            System.out.println("Error, lista no encontrada." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        Conexion.desconectarBBDD();
        return listaUsuarios;
    }

    public static List<Usuario> obtenerUsuario(String nombre) {
        Connection con;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios ORDER BY ?";
        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setString(1,nombre);
            rs = pst.executeQuery();
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
                if (pst!=null){
                    pst.close();
                }
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        Conexion.desconectarBBDD();
        return listaUsuarios;
    }

    public static boolean actualizar(Usuario usuario) {
        boolean actualizar = false;
        Connection con;
        Statement st = null;
        String sql="UPDATE Usuarios SET nombre='"+usuario.getNombre()+"', apellidos='"+usuario.getApellidos()+"', username='"+usuario.getUsername()
                +"', email='"+usuario.getEmail()+"', password='"+usuario.getPassword()+"'" +" WHERE id="+usuario.getId();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Usuario actualizado correctamente.");
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error actualizando el usuario de la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        Conexion.desconectarBBDD();
        return actualizar;
    }

    public static void eliminar(Usuario usuario) {
        Connection con;
        Statement st = null;
        String sql="DELETE FROM Usuarios WHERE ID=" + usuario.getId();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Usuario borrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error eliminado al usuario de la BBDD." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                if (st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
            }
        }
        Conexion.desconectarBBDD();
    }
}