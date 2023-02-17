using Entidades;
using Microsoft.Data.SqlClient;
using System.Net;

namespace DAL.Manejadoras
{
    public class clsManejadoraPersonasDAL
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de una persona.
        /// Recibe una Persona ya editarda para actualizarla en la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Edita a la persona accediendo a la BBDD.
        /// </summary>
        /// <param name="persona">Persona para editar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int editarPersonaDAL(clsPersona persona)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = persona.id;
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = persona.nombre;
            miComando.Parameters.Add("@apellido", System.Data.SqlDbType.VarChar).Value = persona.apellidos;
            miComando.Parameters.Add("@telefono", System.Data.SqlDbType.VarChar).Value = persona.telefono;
            miComando.Parameters.Add("@direccion", System.Data.SqlDbType.VarChar).Value = persona.direccion;
            miComando.Parameters.Add("@foto", System.Data.SqlDbType.VarChar).Value = persona.foto;
            miComando.Parameters.Add("@fechaNac", System.Data.SqlDbType.Date).Value = persona.fechaNacimiento;
            miComando.Parameters.Add("@idDepartamento", System.Data.SqlDbType.Int).Value = persona.idDepartamento;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "UPDATE Personas SET nombre=@nombre, apellidos=@apellido, telefono=@telefono, direccion=@direccion, " +
                    "foto=@foto, fechaNacimiento=@fechaNac, idDepartamento=@idDepartamento  FROM Personas WHERE ID=@id";
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
            finally
            {
                miConexion.closeConnection(ref conexion);
            }
            return numeroFilasAfectadas;
        }
    }
}