﻿using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Manejadoras
{
    public class manejadoraPersonas
    {
        public int deletePersonaDAL(int id)
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
            catch (Exception ex)
            {
                throw ex;
            }
            return numeroFilasAfectadas;
        }
    }
}
