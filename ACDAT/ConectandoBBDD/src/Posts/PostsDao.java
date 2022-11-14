package Posts;

import Controles.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostsDao {

    public static void registrar(Posts post) {
        Connection con;
        Statement st = null;
        String sql = "INSERT INTO Posts VALUES (NULL,'" + post.getIdUsuarios() + "','" + post.getCreated_at() + "','" +
                post.getUpdated_at() + "')";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Post insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error insertando el post en la BBDD." + System.lineSeparator() + e.getMessage());
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

    public static List<Posts> obtener() {
        Connection con;
        Statement st = null;
        ResultSet rs = null;
        List<Posts> listaPosts = new ArrayList<>();
        String sql = "SELECT * FROM Posts ORDER BY idPosts";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Posts post = new Posts();
                post.setIdPosts(rs.getInt(1));
                post.setIdUsuarios(rs.getInt(2));
                post.setCreated_at(rs.getString(3));
                post.setUpdated_at(rs.getString(4));
                listaPosts.add(post);
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
        return listaPosts;
    }

    public static void actualizar(Posts post) {
        Connection con;
        Statement st = null;
        String sql="UPDATE Posts SET idUsuarios='"+post.getIdUsuarios()+"', created_at='"+post.getCreated_at()+"', updated_at='"+post.getUpdated_at()
                +"'" +" WHERE idPosts="+post.getIdPosts();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Post actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error actualizando el post de la BBDD." + System.lineSeparator() + e.getMessage());
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

    public static void eliminar(Posts post) {
        Connection con;
        Statement st = null;
        String sql="DELETE FROM Posts WHERE idPosts=" + post.getIdPosts();
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Post borrado correctamente.");
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
