using Entidades;
using Microsoft.Data.SqlClient;
using Newtonsoft.Json;
using System.Data;


namespace DAL.Listados
{
    public class clsListadoPersonasDAL
    {
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public static async Task<List<clsPersona>> getListadoPersonasDAL()
        {
            //Pido la cadena de la Uri al método estático
            string miCadenaUrl = clsUriBase.getUriBase();
            Uri miUri = new Uri($"{miCadenaUrl}personas");
            List<clsPersona> listadoPersonas = new List<clsPersona>();
            HttpClient mihttpClient;
            HttpResponseMessage miCodigoRespuesta;
            string textoJsonRespuesta;
            //Instanciamos el cliente Http
            mihttpClient = new HttpClient();
            try
            {
                miCodigoRespuesta = await mihttpClient.GetAsync(miUri);
                if (miCodigoRespuesta.IsSuccessStatusCode)
                {
                    textoJsonRespuesta = await mihttpClient.GetStringAsync(miUri);
                    mihttpClient.Dispose();
                    //JsonConvert necesita using Newtonsoft.Json;
                    //Es el paquete Nuget de Newtonsoft
                    listadoPersonas = JsonConvert.DeserializeObject<List<clsPersona>>(textoJsonRespuesta);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listadoPersonas;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public static async Task<clsPersona> obtenerPersonaPorIdDAL(int id)
        {
            //Pido la cadena de la Uri al método estático
            string miCadenaUrl = clsUriBase.getUriBase();
            Uri miUri = new Uri($"{miCadenaUrl}personas/{id}");
            clsPersona persona = new clsPersona();
            HttpClient mihttpClient;
            HttpResponseMessage miCodigoRespuesta;
            string textoJsonRespuesta;
            //Instanciamos el cliente Http
            mihttpClient = new HttpClient();
            try
            {
                miCodigoRespuesta = await mihttpClient.GetAsync(miUri);
                if (miCodigoRespuesta.IsSuccessStatusCode)
                {
                    textoJsonRespuesta = await mihttpClient.GetStringAsync(miUri);
                    mihttpClient.Dispose();
                    persona = JsonConvert.DeserializeObject<clsPersona>(textoJsonRespuesta);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return persona;
        }

        //    /// <summary>
        //    /// Precondiciones: No tiene.
        //    /// Conecto con la BBDD y saco una lista de personas de la tabla Personas para mandar a la BL.
        //    /// Lanza los errores a la capa superior.
        //    /// Postcondiciones: Devuelve una lista de personas de la BBDD.
        //    /// </summary>
        //    /// <returns>List de personas.</returns>
        //    public static List<clsPersona> getListadoPersonasDAL()
        //    {
        //        //DataSet miDataSet = new DataSet(); //Esto es para el modo desconectado, que no tengo aceso a la BBDD
        //        List<clsPersona> listadoPersonasDAL = new List<clsPersona>();

        //        clsMyConnection miConexion = new clsMyConnection();
        //        SqlConnection conexion = new SqlConnection();
        //        SqlCommand miComando = new SqlCommand();
        //        SqlDataReader miLector;
        //        clsPersona miPersona;
        //        try
        //        {
        //            conexion = miConexion.getConnection();
        //            miComando.CommandText = "SELECT * FROM Personas";
        //            miComando.Connection = conexion;
        //            miLector = miComando.ExecuteReader();

        //            if (miLector.HasRows)
        //            {
        //                while (miLector.Read())
        //                {
        //                    miPersona = new clsPersona();
        //                    miPersona.id = (int)miLector["id"];
        //                    miPersona.nombre = (String)miLector["nombre"];
        //                    miPersona.apellidos = (String)miLector["apellidos"];
        //                    miPersona.telefono = (String)miLector["telefono"];
        //                    miPersona.direccion = (String)miLector["direccion"];
        //                    miPersona.foto = (String)miLector["foto"];
        //                    if (miLector["fechaNacimiento"] != DBNull.Value)
        //                    {
        //                        miPersona.fechaNacimiento = (DateTime)miLector["fechaNacimiento"];
        //                    }
        //                    miPersona.idDepartamento = (int)miLector["idDepartamento"];
        //                    listadoPersonasDAL.Add(miPersona);
        //                }
        //            }
        //            miLector.Close();
        //            miConexion.closeConnection(ref conexion);
        //        }
        //        catch (SqlException)
        //        {
        //            throw;
        //        }
        //        catch (Exception)
        //        {
        //            throw;
        //        }
        //        return listadoPersonasDAL;
        //    }

        //    /// <summary>
        //    /// Precondiciones: Debe recivir el id de una persona.
        //    /// Busco en la Base de datos a un usuario pasando el id como parámetro.
        //    /// Lanza los errores a la capa superior.
        //    /// Postcondiciones: Devuelve una persona de la BBDD.
        //    /// </summary>
        //    /// <param name="id">Entero que representa el id de la persona a buscar.</param>
        //    /// <returns>Devuelve una clsPersona encontrada por su id.</returns>
        //    public static clsPersona obtenerPersonaPorIdDAL (int id)
        //    {
        //        clsMyConnection miConexion = new clsMyConnection();
        //        SqlConnection conexion = new SqlConnection();
        //        SqlCommand miComando = new SqlCommand();
        //        SqlDataReader miLector;
        //        clsPersona miPersona = null;
        //        try
        //        {
        //            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;
        //            conexion = miConexion.getConnection();
        //            miComando.CommandText = "SELECT * FROM Personas WHERE id = @id";             
        //            miComando.Connection = conexion;
        //            miLector = miComando.ExecuteReader();

        //            if (miLector.HasRows)
        //            {
        //                while (miLector.Read())
        //                {
        //                    miPersona = new clsPersona();
        //                    miPersona.id = (int)miLector["id"];
        //                    miPersona.nombre = (String)miLector["nombre"];
        //                    miPersona.apellidos = (String)miLector["apellidos"];
        //                    miPersona.telefono = (String)miLector["telefono"];
        //                    miPersona.direccion = (String)miLector["direccion"];
        //                    miPersona.foto = (String)miLector["foto"];
        //                    if (miLector["fechaNacimiento"] != DBNull.Value)
        //                    {
        //                        miPersona.fechaNacimiento = (DateTime)miLector["fechaNacimiento"];
        //                    }
        //                    miPersona.idDepartamento = (int)miLector["idDepartamento"];
        //                }
        //            }
        //            miLector.Close();
        //            miConexion.closeConnection(ref conexion);
        //        }
        //        catch (SqlException)
        //        {
        //            throw;
        //        }
        //        catch (Exception)
        //        {
        //            throw;
        //        }
        //        return miPersona;
        //    }
    }
}