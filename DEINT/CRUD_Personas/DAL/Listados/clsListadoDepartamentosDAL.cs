using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Listados
{
    public class clsListadoDepartamentosDAL
    {
        public static List<clsDepartamentos> getListadoDepartamentosDAL()
        {
            DataSet miDataSet = new DataSet();
            List<clsDepartamentos> listadoDepartamentosDAL = new List<clsDepartamentos>();


            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsDepartamentos miDepartamento;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Departamentos";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miDepartamento = new clsDepartamentos();

                        miDepartamento.Id = (int)miLector["Id"];
                        miDepartamento.Nombre = (String)miLector["Nombre"];
                        listadoDepartamentosDAL.Add(miDepartamento);
                    }
                }
                miLector.Close();
                conexion.Close();
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

    }
}
