using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Api_Damas.Entidades
{
    public class clsSala
    {
        #region Attributes
        private int _codSala;
        private string _nombreSala;
        private clsJugador _jugadorArriba;
        private clsJugador _jugadorAbajo;
        private long _tiempo;
        private int _cantidadFichasArriba;
        private int _cantidadFichasAbajo;
        #endregion

        #region Properties
        public int codSala { get { return _codSala; } set { _codSala = value; } }
        public string nombreSala { get { return _nombreSala; } set { _nombreSala = value; } }
        public clsJugador jugadorArriba { get { return _jugadorArriba; } set { _jugadorArriba = value; } }
        public clsJugador jugadorAbajo { get { return _jugadorAbajo; } set { _jugadorAbajo = value; } }
        public long tiempo { get { return _tiempo; } set { _tiempo = value; } }
        public int cantidadFichasArriba { get { return _cantidadFichasArriba; } set { _cantidadFichasArriba = value; } }
        public int cantidadFichasAbajo { get { return _cantidadFichasAbajo; } set { _cantidadFichasAbajo = value; } }
        #endregion

        #region Constructors
        public clsSala() { }
        public clsSala(int _codSala, string _nombreSala, clsJugador _jugadorArriba, clsJugador _jugadorAbajo, long _tiempo, int _cantidadFichasArriba, int _cantidadFichasAbajo)
        {
            codSala = _codSala;
            nombreSala = _nombreSala;
            jugadorArriba = _jugadorArriba;
            jugadorAbajo = _jugadorAbajo;
            tiempo = _tiempo;
            cantidadFichasArriba = _cantidadFichasArriba;
            cantidadFichasAbajo = _cantidadFichasAbajo;
        }
        public clsSala(int _codSala, string _nombreSala, clsJugador _jugadorArriba, clsJugador _jugadorAbajo, long _tiempo)
        {
            codSala = _codSala;
            nombreSala = _nombreSala;
            jugadorArriba = _jugadorArriba;
            jugadorAbajo = _jugadorAbajo;
            tiempo = _tiempo;
            cantidadFichasArriba = 12;
            cantidadFichasAbajo = 12;
        }
        #endregion
    }
}
