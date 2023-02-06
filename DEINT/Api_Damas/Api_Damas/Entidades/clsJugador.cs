using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Api_Damas.Entidades
{
    public class clsJugador
    {
        #region Attributes
        private int _idJugador;
        private string _nombre;
        private string _password;
        //private List<clsSala> _partidasJugadas;
        #endregion

        #region Properties
        public int idJugador { get { return _idJugador; } set { _idJugador = value; } }
        public string nombre { get { return _nombre; } set { _nombre = value; } }
        public string password { get { return _password; } set { _password = value; } }
        //public List<clsSala> partidasJugadas { get { return _partidasJugadas; } set { _partidasJugadas = value; } }
        #endregion

        #region Constructors
        public clsJugador() { }
        public clsJugador(string _nombre, string _password)
        {
            nombre = _nombre;
            password = _password;
        }
        public clsJugador(int _idJugador, string _nombre, string _password)
        {
            idJugador = _idJugador;
            nombre = _nombre;
            password = _password;
        }
        //public clsJugador(string _nombre, string _password, List<clsSala> _partidasJugadas)
        //{
        //    nombre = _nombre;
        //    password = _password;
        //    partidasJugadas = _partidasJugadas;
        //}
        #endregion
    }
}