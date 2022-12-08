using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL.Manejadoras
{
    public class clsManejadoraDepartamentosDAL
    {
        /// <summary>
        /// Recibe un entero que es el id del departamento a eliminar y accede a la base de datos para eliminarlo.
        /// </summary>
        /// <param name="id">Entero que representa el id del departamento a eliminar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarDepartamentosDAL(int id)
        {
            int numeroFilasAfectadas = 0;

            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();

            SqlCommand miComando = new SqlCommand();

            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;

            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "DELETE FROM Departamentos WHERE Id=@id";
                miComando.Connection = conexion;
                numeroFilasAfectadas = miComando.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return numeroFilasAfectadas;
        }

        /// <summary>
        /// Recibe un departamento ya editado para actualizarlo en la base de datos.
        /// </summary>
        /// <param name="departamento">Departamento para editar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int editarDepartamentoDAL(clsDepartamentos departamento)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = departamento.Id;
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = departamento.Nombre;

            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "UPDATE Departamentos SET Nombre=@nombre FROM Departamentos WHERE ID=@id";
                miComando.Connection = conexion;
                numeroFilasAfectadas = miComando.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return numeroFilasAfectadas;
        }

        /// <summary>
        /// Recibe un departamentos ya relleno para insertarlo en la base de datos.
        /// </summary>
        /// <param name="persona">Departamento para insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarDepartamentoDAL(clsDepartamentos departamento)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = departamento.Id;
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = departamento.Nombre;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "INSERT INTO Departamentos VALUES(@nombre)";
                miComando.Connection = conexion;
                numeroFilasAfectadas = miComando.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return numeroFilasAfectadas;
        }
    }
}
