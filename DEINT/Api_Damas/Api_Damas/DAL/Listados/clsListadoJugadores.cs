using Api_Damas.Entidades;
using DAL;
using Microsoft.Data.SqlClient;
using System.Data;


namespace Api_Damas.DAL.Listados
{
    public class clsListadoJugadores
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco una lista de personas de la tabla Personas para mandar a la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de personas de la BBDD.
        /// </summary>
        /// <returns>List de personas.</returns>
        public static List<clsJugador> getListadoJugadores()
        {
            List<clsJugador> listadoPersonasDAL = new List<clsJugador>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsJugador miJugador;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Jugadores";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miJugador = new clsJugador();
                        miJugador.nombre = (string)miLector["nombre"];
                        miJugador.password = (string)miLector["password"];
                        miJugador.partidasJugadas = (List<clsSala>)miLector["partidasJugadas"];
                        listadoPersonasDAL.Add(miJugador);
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
            return listadoPersonasDAL;
        }

        /// <summary>
        /// Precondiciones: Debe recivir el id de una persona.
        /// Busco en la Base de datos a un usuario pasando el id como parámetro.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una persona de la BBDD.
        /// </summary>
        /// <param name="id">Entero que representa el id de la persona a buscar.</param>
        /// <returns>Devuelve una clsPersona encontrada por su id.</returns>
        public static clsJugador getJugadorPorId(int id)
        {
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsJugador miJugador = null;
            try
            {
                miComando.Parameters.Add("@id", SqlDbType.Int).Value = id;
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Jugadores WHERE id = @id";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miJugador = new clsJugador();
                        miJugador.nombre = (string)miLector["nombre"];
                        miJugador.password = (string)miLector["password"];
                        miJugador.partidasJugadas = (List<clsSala>)miLector["partidasJugadas"];
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
            return miJugador;
        }
    }
}