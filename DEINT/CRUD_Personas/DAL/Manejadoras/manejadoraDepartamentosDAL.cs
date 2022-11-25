using Microsoft.Data.SqlClient;

namespace DAL.Manejadoras
{
    public class manejadoraDepartamentosDAL
    {
        public static int deleteDepartamentosDAL(int id)
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
