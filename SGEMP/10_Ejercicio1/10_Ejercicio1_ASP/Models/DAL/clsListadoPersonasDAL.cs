using _10_Ejercicio1_ASP.Models.Entidades;
using Microsoft.Data.SqlClient;

namespace _10_Ejercicio1_ASP.Models.DAL
{
    public class clsListadoPersonasDAL
    {
        public List<clsPersona> getListadoPersonasDAL()
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

                
            }
            catch (Exception e)
            {
                 
            }
            finally
            {
                miConexion?.Close();
            }
            return listadoPersonasDAL;
        }
    }
}
