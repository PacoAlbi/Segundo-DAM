import java.sql.*;

public class Main {


    private static Statement st = null;
    private static PreparedStatement prst = null;

    public static void main(String[] args) {
        String sql = "show tables";
        String sql1 = "SELECT NombreCompañia, NombreContacto, Ciudad FROM Clientes";
        String sql2 = "SELECT NombreContacto, Direccion, CodPostal FROM Clientes ORDER BY CodPostal desc, Direccion desc";
        String sql3 = "SELECT P.NombreProducto, C.NombreCategoria, P.PrecioUnidad FROM Productos as P INNER JOIN Categorias as C ON P.IdCategoria = C.IdCategoria ORDER BY C.NombreCategoria, P.NombreProducto";
        String sql4 = "SELECT P.NombreProducto, C.NombreCategoria, P.PrecioUnidad FROM                                                                                                                                                                                                                                              Productos P, Categorias C WHERE P.IdCategoria = C.IdCategoria ORDER BY C.NombreCategoria, P.NombreProducto";
        Connection con = Conexion.conectarBBDD();
        ResultSet rs;
        ResultSetMetaData rsmd;
        int contador = 0;
        try {
            prst = con.prepareStatement(sql4);
            rs = prst.executeQuery();
            rsmd = rs.getMetaData();
            while (rs.next()){
                System.out.println(rsmd.getColumnName(1) + ": " + rs.getString(1) + ", " + rsmd.getColumnName(2) + ": " +  rs.getString(2) + ", " + rsmd.getColumnName(3) + ": " +  rs.getString(3));
                contador++;
            }
            System.out.println("Total: " + contador);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}