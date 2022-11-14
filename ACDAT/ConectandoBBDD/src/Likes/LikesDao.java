package Likes;

import Controles.Conexion;
import Usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikesDao {

    public static List<Likes> obtener() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Likes> listaLikes = new ArrayList<>();
        String sql = "SELECT * FROM Likes ORDER BY idLikes";
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Likes likes = new Likes();
                likes.setIdLikes(rs.getInt(1));
                likes.setIdUsuarios(rs.getInt(2));
                likes.setIdPosts(rs.getInt(3));
                listaLikes.add(likes);
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
        return listaLikes;
    }

    public static void eliminar(int id) {
        Connection con = null;
        Statement st = null;
        String sql="DELETE FROM Likes WHERE idUsuarios = " + id;
        try {
            con = Conexion.conectar();
            st = con.createStatement();
            st.execute(sql);
            System.out.println("Likes borrados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error eliminado los likes de la BBDD." + System.lineSeparator() + e.getMessage());
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
