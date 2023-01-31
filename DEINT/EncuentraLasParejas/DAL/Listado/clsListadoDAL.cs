using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Listado
{
    public class clsListadoDAL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco una lista de jugadores para la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de jugadores de la BBDD.
        /// </summary>
        /// <returns>List de jugadores.</returns>
        public static List<clsJugador> getListadoJugadoresDAL()
        {
            List<clsJugador> listaJugadoresDAL = new List<clsJugador>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsJugador jugador;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM JuegoParejas";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        jugador = new clsJugador();
                        jugador.Id = (int)miLector["id"];
                        jugador.Nombre = (String)miLector["nombre"];
                        jugador.Tiempo = (int)miLector["tiempo"];     
                        listaJugadoresDAL.Add(jugador);
                    }
                }
                miLector.Close();
                miConexion.closeConnection(ref conexion);
            }
            catch (SqlException)
            {
                throw;
            }
            catch (Exception)
            {
                throw;
            }
            return listaJugadoresDAL;
        }
    }
}
