using Entidades;
using Microsoft.Data.SqlClient;


namespace DAL.Manejadoras
{
    public class clsManejadoraPersonasDAL
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de una persona.
        /// Recibe un entero que es el id de la persona a eliminar y accede a la base de datos para eliminarla.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Borra la persona accediendo a la BBDD.
        /// </summary>
        /// <param name="id">Entero que es el ID de la persona.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarPersonaDAL(int id)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;

            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "DELETE FROM Personas WHERE Id=@id";
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
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = persona.Id;
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = persona.Nombre;
            miComando.Parameters.Add("@apellido", System.Data.SqlDbType.VarChar).Value = persona.Apellidos;
            miComando.Parameters.Add("@telefono", System.Data.SqlDbType.VarChar).Value = persona.Telefono;
            miComando.Parameters.Add("@direccion", System.Data.SqlDbType.VarChar).Value = persona.Direccion;
            miComando.Parameters.Add("@foto", System.Data.SqlDbType.VarChar).Value = persona.Foto;
            miComando.Parameters.Add("@fechaNac", System.Data.SqlDbType.Date).Value = persona.FechaNacimiento;
            miComando.Parameters.Add("@idDepartamento", System.Data.SqlDbType.Int).Value = persona.IdDepartamento;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "UPDATE Personas SET Nombre=@nombre, Apellidos=@apellido, Telefono=@telefono, Direccion=@direccion, " +
                    "Foto=@foto, FechaNacimiento=@fechaNac, IdDepartamento=@idDepartamento  FROM Personas WHERE ID=@id";
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

        /// <summary>
        /// Precondiciones: Debe recivir una persona rellena.
        /// Recibe una persona ya rellena para insertarla en la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Inserta una nueva persona accediendo a la BBDD.
        /// </summary>
        /// <param name="persona">Persona para insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarPersonasDAL(clsPersona persona)
        {
            int numeroFilasAfectadas = 0;
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = persona.Id; //Realemente me hace falta? tengo que probarlo.
            miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = persona.Nombre;
            miComando.Parameters.Add("@apellido", System.Data.SqlDbType.VarChar).Value = persona.Apellidos;
            miComando.Parameters.Add("@telefono", System.Data.SqlDbType.VarChar).Value = persona.Telefono;
            miComando.Parameters.Add("@direccion", System.Data.SqlDbType.VarChar).Value = persona.Direccion;
            miComando.Parameters.Add("@foto", System.Data.SqlDbType.VarChar).Value = persona.Foto;
            miComando.Parameters.Add("@fechaNac", System.Data.SqlDbType.Date).Value = persona.FechaNacimiento;
            miComando.Parameters.Add("@idDepartamento", System.Data.SqlDbType.Int).Value = persona.IdDepartamento;
            try
            {               
                conexion = miConexion.getConnection();
                miComando.CommandText = "INSERT INTO Personas VALUES(@nombre,@apellido,@telefono,@direccion,@foto,@fechaNac,@idDepartamento)";
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
