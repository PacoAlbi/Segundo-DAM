using Microsoft.Data.SqlClient;

namespace DAL
{
    public class clsMyConnection
    {
        #region Atributos
        public String server { get; set; }
        public String dataBase { get; set; }
        public String user { get; set; }
        public String pass { get; set; }
        #endregion
        //Constructores
        #region Constructores
        public clsMyConnection()
        {
            this.server = $"107-04\\SQLEXPRESS";
            this.dataBase = "Examen";
            this.user = "prueba";
            this.pass = "123";
        }
        //Con parámetros por si quisiera cambiar las conexiones
        public clsMyConnection(String server, String database, String user, String pass)
        {
            this.server = server;
            this.dataBase = database;
            this.user = user;
            this.pass = pass;
        }
        #endregion
        #region Métodos
        //METODOS
        /// <summary>
        /// Precondición: No tiene.
        /// Método que abre una conexión con la base de datos.
        /// Postcondición: Abre conexión.
        /// </summary>
        /// <returns>Una conexión abierta con la base de datos</returns>
        public SqlConnection getConnection()
        {
            SqlConnection connection = new SqlConnection();
            try
            {
                connection.ConnectionString = $"server={server};database={dataBase};uid={user};pwd={pass};Trust Server Certificate = true;";
                connection.Open();
            }
            catch (SqlException)
            {
                throw;
            }
            return connection;
        }
        /// <summary>
        /// Precondición: Debe recibir una conexión.
        /// Este metodo cierra una conexión con la Base de datos.
        /// Postcondición: Cierra conexión.
        /// </summary>
        /// <post>La conexion es cerrada</post>
        /// <param name="connection">SqlConnection por referencia. Conexion a cerrar
        /// </param>
        public void closeConnection(ref SqlConnection connection)
        {
            try
            {
                connection.Close();
            }
            catch (SqlException)
            {
                throw;
            }
            catch (InvalidOperationException)
            {
                throw;
            }
            catch (Exception)
            {
                throw;
            }
        }
        #endregion
    }
}