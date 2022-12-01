package Eva.dao;

import Eva.entidades.Equipos;
import Eva.manejadora.ManejadoraDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
    public static void main(String[] args) {
        crearTablaEInsertarDatos();
    }
    /*
      Sentencia de llamada u orden para la BBDD(insert into, alter table...), solo lleva un String
       y no puede llevar parametros
       */
    private static Statement statement = null;
    /*
    es igual que el anterior pero para poder usar los paramentros
     */
    public static PreparedStatement preparedStatement = null;
    public static Connection con;
    /**
     * Metodo para crear la tabla del equipo de futbol
     * @param tabla nombre de la tabla
     * @param campos array de la lectura del fichero
     */
    public static void crearTablas(String tabla, String[] campos){




        String crear="CREATE TABLE "+tabla+"(";
        for (int i=0;i<campos.length;i++){
            crear+=campos[i];
        }
        crear+=")";

        System.out.println(crear);
        try {

            con =  Conexion.conectar();
            statement= con.prepareStatement(crear);
            statement.executeUpdate(crear);
            System.out.println("Tabla "+ tabla+ " creada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Método que se encarga de insertar un equipo en la base de datos seleccionada.
     * @param equipo objeto Equipo que se insertará en la base de datos.
     *
     * @return insertado: booleano que muestra si el objeto se insertó con éxito en la base de datos
     */
    public static boolean insertarEquipo(Equipos equipo){
        var insertado = false;
        Connection cnn = null;
        try{

            cnn = Conexion.conectar();
            var sql = String.format("Insert Into ad2223_eramos.Equipos values%s", equipo.toString());
            Statement sttmnt = cnn.createStatement();
            sttmnt.executeUpdate(sql);
            insertado = true;

        } catch (SQLException e) {
            System.err.printf("Los datos que se introdujeron no eran correctos: %n %s %n", e.getMessage());
        }


        return insertado;
    }
    public static void crearTablaEInsertarDatos(){

        String[] campo={"idEquipo varchar(50) PRIMARY KEY,","ganados int,","empatados int,","perdidos int,"
                ,"golesMarcados int,","golesRecibidos int"};
            crearTablas("Equipos", campo);
            ManejadoraDAO.lecturaFichero();
            System.out.println("Exito");
            Conexion.desconectar();
    }
}
