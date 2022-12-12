using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL.Manejadoras
{
    public class clsManejadoraDepartamentosDAL
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de un departamento.
        /// Recibe un entero que es el id del departamento a eliminar y accede a la base de datos para eliminarlo.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Borra el departamento accediendo a la BBDD.
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
    }
}