using _10_Ejercicio1_ASP.Models.Entidades;
using Microsoft.Data.SqlClient;

namespace _10_Ejercicio1_ASP.Models.DAL
{
    public class clsListadoPersonasDAL
    {
        public static List<clsPersona> getListadoPersonasDAL()
        {

            List<clsPersona> listadoPersonasDAL= new List<clsPersona>();
            SqlConnection miConexion = new SqlConnection();
            miConexion.ConnectionString = "server=falbinana.database.windows.net;database=PacoBBDD;uid=falbinana;pwd=Mandaloriano69";
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsPersona persona;
            try
            {
                miConexion.Open();
                miComando.CommandText = "SELECT * FROM Personas";
                miComando.Connection= miConexion;
                miLector= miComando.ExecuteReader();    

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        persona= new clsPersona();

                        persona.Id = (int)miLector["Id"];
                        persona.Nombre = (String)miLector["Nombre"];
                        persona.Apellidos = (String)miLector["Apellidos"];
                        persona.Telefono = (String)miLector["Telefono"];
                        persona.Direccion = (String)miLector["Direccion"];
                        persona.Foto = (String)miLector["Foto"];
                        if (miLector["FechaNacimiento"] != DBNull.Value)
                        {
                            persona.FechaNacimiento = (DateTime)miLector["FechaNacimiento"];
                        }

                        persona.IdDepartamento = (int)miLector["IdDepartamento"];
                        listadoPersonasDAL.Add(persona);

                    }
                }

                miLector.Close();
                miConexion.Close();
                
            }
            catch (SqlException e)
            {
                throw e;
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                miConexion?.Close();
            }
            return listadoPersonasDAL;
        }
    }
}
