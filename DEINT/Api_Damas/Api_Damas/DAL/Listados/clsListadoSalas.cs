using Api_Damas.Entidades;
using DAL;
using Microsoft.Data.SqlClient;

namespace Api_Damas.DAL.Listados
{
    public class clsListadoSalas
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco un lista de departamentos de la tabla Departamentos para mandar a la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de departamentos.
        /// </summary>
        /// <returns>List de departamentos.</returns>
        public static List<clsSala> getListadoDepartamentosDAL()
        {
            List<clsSala> listadoDepartamentosDAL = new List<clsSala>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsSala miSala;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM FROM Salas";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();
                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miSala = new clsSala();
                        miSala.codSala = miLector.GetInt32(0);
                        miSala.nombreSala = miLector.GetString(1);
                        listadoDepartamentosDAL.Add(miSala);
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
            return listadoDepartamentosDAL;
        }
        /// <summary>
        /// Precondiciones: Debe recivbir el id de un departamento.
        /// Busco en la base de datos un departamento por su id.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una persona de la BBDD.
        /// </summary>
        /// <param name="Id">Paso el id del departamento a buscar.</param>
        /// <returns>Devuelvo un clsDepartamento si lo hemos encontrado.</returns>
        public static clsSala obtenerDepartamentoPorIdDAL(int Id)
        {
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsSala miSala = null;
            try
            {
                miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = Id;
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Salas WHERE codSala = @id";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();
                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miSala = new clsSala();
                        miSala.codSala = miLector.GetInt32(0);
                        miSala.nombreSala = miLector.GetString(1);
                        miSala.cantidadFichasArriba = miLector.GetString(2);
                        miSala.cantidadFichasAbajo = miLector.GetString(3);
                        miSala.tiempo = miLector.GetDouble(4);
                        miSala.cantidadFichasArriba = miLector.GetInt32(5);
                        miSala.cantidadFichasAbajo = miLector.GetInt32(6);
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
            return miSala;
        }
    }
}