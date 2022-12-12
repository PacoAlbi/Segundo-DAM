using Entidades;
using Microsoft.Data.SqlClient;


namespace DAL.Manejadoras
{
    public class clsManejadoraPersonasDAL
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de un departamento.
        /// Recibe un entero que es el id del departamento de las personas que queremos borrar.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Borra la persona accediendo a la BBDD.
        /// </summary>
        /// <param name="id">Entero que es el ID del departamento.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarPersonaPorDepartamentoDAL(int id)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;

            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "DELETE FROM Personas WHERE IdDepartamento=@id";
                miComando.Connection = conexion;
                numeroFilasAfectadas = miComando.ExecuteNonQuery();
            }
            catch (SqlException)
            {
                throw;
            }
            catch (Exception)
            {
                throw;
            }
            return numeroFilasAfectadas;
        }
    }
}