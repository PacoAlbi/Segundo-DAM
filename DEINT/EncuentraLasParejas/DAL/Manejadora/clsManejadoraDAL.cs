using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Manejadora
{
    public class clsManejadoraDAL
    {
        /// <summary>
        /// Precondiciones: Debe recivir un jugador.
        /// Recibe un jugador ya rellena para insertar en la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Inserta un nuevo jugador.
        /// </summary>
        /// <param name="jugador">Jugador para insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarJugadorDAL(clsJugador jugador)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = jugador.Id;
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = jugador.Nombre;
            miComando.Parameters.Add("@tiempo", System.Data.SqlDbType.Int).Value = jugador.Tiempo;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "INSERT INTO JuegoParejas VALUES(@nombre,@tiempo)";
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
