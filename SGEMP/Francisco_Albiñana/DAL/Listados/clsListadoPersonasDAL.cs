using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;


namespace DAL.Listados
{
    public class clsListadoPersonasDAL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco una lista de personas de la tabla Personas para mandar a la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de personas de la BBDD.
        /// </summary>
        /// <returns>List de personas.</returns>
        public static List<clsPersona> getListadoPersonasDAL()
        {
            List<clsPersona> listadoPersonasDAL = new List<clsPersona>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsPersona miPersona;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Personas";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miPersona = new clsPersona();
                        miPersona.Id = (int)miLector["Id"];
                        miPersona.Nombre = (String)miLector["Nombre"];
                        miPersona.Apellidos = (String)miLector["Apellidos"];
                        miPersona.Telefono = (String)miLector["Telefono"];
                        miPersona.Direccion = (String)miLector["Direccion"];
                        miPersona.Foto = (String)miLector["Foto"];
                        if (miLector["FechaNacimiento"] != DBNull.Value)
                        {
                            miPersona.FechaNacimiento = (DateTime)miLector["FechaNacimiento"];
                        }
                        miPersona.IdDepartamento = (int)miLector["IdDepartamento"];
                        listadoPersonasDAL.Add(miPersona);
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
        /// Busco en la Base de datos a un usuario pasando el Id como parámetro.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una persona de la BBDD.
        /// </summary>
        /// <param name="Id">Entero que representa el Id de la persona a buscar.</param>
        /// <returns>Devuelve una clsPersona encontrada por su Id.</returns>
        public static clsPersona obtenerPersonaPorIdDAL (int Id)
        {
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsPersona miPersona = null;
            try
            {
                miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = Id;
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Personas WHERE Id = @id";             
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miPersona = new clsPersona();
                        miPersona.Id = (int)miLector["Id"];
                        miPersona.Nombre = (String)miLector["Nombre"];
                        miPersona.Apellidos = (String)miLector["Apellidos"];
                        miPersona.Telefono = (String)miLector["Telefono"];
                        miPersona.Direccion = (String)miLector["Direccion"];
                        miPersona.Foto = (String)miLector["Foto"];
                        if (miLector["FechaNacimiento"] != DBNull.Value)
                        {
                            miPersona.FechaNacimiento = (DateTime)miLector["FechaNacimiento"];
                        }
                        miPersona.IdDepartamento = (int)miLector["IdDepartamento"];
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
            return miPersona;
        }

        /// <summary>
        /// Precondiciones: Debe recivir el id de un departamento.
        /// Busco en la Base de datos a un usuario pasando el Id del departamento como parámetro.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista persona de la BBDD.
        /// </summary>
        /// <param name="Id">Entero que representa el Id de la persona a buscar.</param>
        /// <returns>Devuelve una List<clsPersona> encontrado por su Id.</returns>
        public static List<clsPersona> obtenerPersonasPorIdDepartamentoDAL(int Id)
        {
            List<clsPersona> listadoPersonasPorIdDepartamentoDAL = new List<clsPersona>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsPersona miPersona = null;
            try
            {
                miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = Id;
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Personas WHERE IdDepartamento = @id";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miPersona = new clsPersona();
                        miPersona.Id = (int)miLector["Id"];
                        miPersona.Nombre = (String)miLector["Nombre"];
                        miPersona.Apellidos = (String)miLector["Apellidos"];
                        miPersona.Telefono = (String)miLector["Telefono"];
                        miPersona.Direccion = (String)miLector["Direccion"];
                        miPersona.Foto = (String)miLector["Foto"];
                        if (miLector["FechaNacimiento"] != DBNull.Value)
                        {
                            miPersona.FechaNacimiento = (DateTime)miLector["FechaNacimiento"];
                        }
                        miPersona.IdDepartamento = (int)miLector["IdDepartamento"];
                    }
                    listadoPersonasPorIdDepartamentoDAL.Add(miPersona);
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
            return listadoPersonasPorIdDepartamentoDAL;
        }
    }
}
