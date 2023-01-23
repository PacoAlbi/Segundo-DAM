using Entidades;
using Microsoft.Data.SqlClient;
using Newtonsoft.Json;
using System.Net;

namespace DAL.Manejadoras
{
    public class clsManejadoraDepartamentosDAL
    {
        public static async Task<HttpStatusCode> insertarDepartamentoDAL(clsDepartamentos departamento)

        {
            HttpClient mihttpClient = new HttpClient();
            string datos;
            HttpContent contenido;
            string miCadenaUrl = clsUriBase.getUriBase();
            Uri miUri = new Uri($"{miCadenaUrl}departamentos");
            HttpResponseMessage miRespuesta = new HttpResponseMessage();
            try
            {
                datos = JsonConvert.SerializeObject(departamento);
                contenido = new StringContent(datos, System.Text.Encoding.UTF8, "application/json");
                miRespuesta = await mihttpClient.PostAsync(miUri, contenido);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return miRespuesta.StatusCode;
        }

        public static async Task<HttpStatusCode> editarDepartamentoDAL(clsDepartamentos departamento)
        {
            HttpClient mihttpClient = new HttpClient();
            string datos;
            HttpContent contenido;
            string miCadenaUrl = clsUriBase.getUriBase();
            Uri miUri = new Uri($"{miCadenaUrl}departamentos/{departamento.id}");
            HttpResponseMessage miRespuesta = new HttpResponseMessage();
            try
            {
                datos = JsonConvert.SerializeObject(departamento);
                contenido = new StringContent(datos, System.Text.Encoding.UTF8, "application/json");
                miRespuesta = await mihttpClient.PutAsync(miUri, contenido);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return miRespuesta.StatusCode;
        }
        public static async Task<HttpStatusCode> borrarDepartamentosDAL(int id)
        {
            HttpClient mihttpClient = new HttpClient();
            string datos;
            HttpContent contenido;
            string miCadenaUrl = clsUriBase.getUriBase();
            Uri miUri = new Uri($"{miCadenaUrl}departamentos/{id}");
            HttpResponseMessage miRespuesta = new HttpResponseMessage();
            try
            {
                miRespuesta = await mihttpClient.DeleteAsync(miUri);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return miRespuesta.StatusCode;
        }

        ///// <summary>
        ///// Precondiciones: Deber recivir la id de un departamento.
        ///// Recibe un entero que es el id del departamento a eliminar y accede a la base de datos para eliminarlo.
        ///// Lanza los errores a la capa superior.
        ///// Postcondiciones: Borra el departamento accediendo a la BBDD.
        ///// </summary>
        ///// <param name="id">Entero que representa el id del departamento a eliminar.</param>
        ///// <returns>Entero con el número de filas afectadas si las hay.</returns>
        //public static int borrarDepartamentosDAL(int id)
        //{
        //    int numeroFilasAfectadas = 0;

        //    clsMyConnection miConexion = new clsMyConnection();
        //    SqlConnection conexion = new SqlConnection();

        //    SqlCommand miComando = new SqlCommand();

        //    miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;

        //    try
        //    {
        //        conexion = miConexion.getConnection();
        //        miComando.CommandText = "DELETE FROM Departamentos WHERE id=@id";
        //        miComando.Connection = conexion;
        //        numeroFilasAfectadas = miComando.ExecuteNonQuery();
        //    }
        //    catch (Exception ex)
        //    {
        //        throw ex;
        //    }
        //    return numeroFilasAfectadas;
        //}

        ///// <summary>
        ///// Precondiciones: Deber recivir la id de un departamento.
        ///// Recibe un departamento ya editado para actualizarlo en la base de datos.
        ///// Lanza los errores a la capa superior.
        ///// Postcondiciones: Edita el departamento accediendo a la BBDD.
        ///// </summary>
        ///// <param name="departamento">Departamento para editar.</param>
        ///// <returns>Entero con el número de filas afectadas si las hay.</returns>
        //public static int editarDepartamentoDAL(clsDepartamentos departamento)
        //{
        //    int numeroFilasAfectadas = 0;
        //    clsMyConnection miConexion = new clsMyConnection();
        //    SqlConnection conexion = new SqlConnection();
        //    SqlCommand miComando = new SqlCommand();
        //    miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = departamento.id;
        //    miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = departamento.nombre;

        //    try
        //    {
        //        conexion = miConexion.getConnection();
        //        miComando.CommandText = "UPDATE Departamentos SET nombre=@nombre FROM Departamentos WHERE ID=@id";
        //        miComando.Connection = conexion;
        //        numeroFilasAfectadas = miComando.ExecuteNonQuery();
        //    }
        //    catch (SqlException)
        //    {
        //        throw;
        //    }
        //    catch (Exception)
        //    {
        //        throw;
        //    }
        //    return numeroFilasAfectadas;
        //}

        ///// <summary>
        ///// Precondiciones: Debe recivir un departamento relleno.
        ///// Recibe un departamentos ya relleno para insertarlo en la base de datos.
        ///// Lanza los errores a la capa superior.
        ///// Postcondiciones: Inserta un nuevo departamento accediendo a la BBDD.
        ///// </summary>
        ///// <param name="persona">Departamento para insertar.</param>
        ///// <returns>Entero con el número de filas afectadas si las hay.</returns>
        //public static int insertarDepartamentoDAL(clsDepartamentos departamento)
        //{
        //    int numeroFilasAfectadas = 0;
        //    clsMyConnection miConexion = new clsMyConnection();
        //    SqlConnection conexion = new SqlConnection();
        //    SqlCommand miComando = new SqlCommand();
        //    miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = departamento.id;
        //    miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = departamento.nombre;
        //    try
        //    {
        //        conexion = miConexion.getConnection();
        //        miComando.CommandText = "INSERT INTO Departamentos VALUES(@nombre)";
        //        miComando.Connection = conexion;
        //        numeroFilasAfectadas = miComando.ExecuteNonQuery();
        //    }
        //    catch (SqlException)
        //    {
        //        throw;
        //    }
        //    catch (Exception)
        //    {
        //        throw;
        //    }
        //    return numeroFilasAfectadas;
        //}
    }
}