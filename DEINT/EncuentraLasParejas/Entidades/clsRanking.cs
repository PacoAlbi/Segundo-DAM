using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class clsRanking
    {
        #region Atributos
        private string nick;
        private string tiempo;
        #endregion

        #region Propiedades
        public string Nick { get { return nick; } set { nick = value; } }
        public string Tiempo { get { return tiempo; } set { tiempo = value; } }
        #endregion

        #region Constructores
        public clsRanking() {}
        public clsRanking(string nick, string tiempo)
        {
            Nick = nick;
            Tiempo = tiempo;
        }
        #endregion
    }
}
