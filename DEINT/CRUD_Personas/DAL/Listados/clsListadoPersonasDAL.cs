using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Listados
{
    public class clsListadoPersonasDAL
    {

        public List<clsPersona> getListadoPersonasDAL() 
        {   
            DataSet miDataSet = new DataSet();
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
                miComando.Connection= conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miPersona = new clsPersona();




                    }

                } else
                {
                    
                }
            }
            catch (SqlException ex)
            {
                throw ex;
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listadoPersonasDAL;
        }

    }
}
