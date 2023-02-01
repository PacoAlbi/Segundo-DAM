using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class clsJugador
    {
        #region Atributos
        private int id;
        private string nombre;
        private int tiempo;
        #endregion

        #region Propiedades
        public int Id { get { return id; } set { id = value; } }
        public string Nombre { get { return nombre; } set { nombre = value; } }
        public int Tiempo { get { return tiempo; } set { tiempo = value; } }
        #endregion

        #region Constructores
        public clsJugador() {}
        public clsJugador(int id, string nick, int tiempo)
        {
            Id = id;
            Nombre = nick;
            Tiempo = tiempo;
        }
        public clsJugador(string nick, int tiempo)
        {
            Nombre = nick;
            Tiempo = tiempo;
        }
        #endregion
    }
}
