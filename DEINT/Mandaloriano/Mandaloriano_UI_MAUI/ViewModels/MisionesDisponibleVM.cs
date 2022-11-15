using Mandaloriano_BL;
using Mandaloriano_DAL;
using Mandaloriano_Entidades;
using Mandaloriano_UI_MAUI.ViewModels.Utilidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Mandaloriano_UI_MAUI.ViewModels
{
    public class MisionesDisponibleVM : clsVMBase
    {
        #region atributos
        private DelegateCommand mostrarDescripcion;
        private ObservableCollection<clsMisiones> listadoDeMisiones;
        private clsMisiones misionSeleccionada;
        private bool visivilidadDescripcion;

        public DelegateCommand MostrarDescripcion
        {
            get 
            {
                mostrarDescripcion = new DelegateCommand(MostrarDescripcion_Executed, MostrarDescripcion_CanExecute);
                return mostrarDescripcion;
            }
        }

        public bool VisivilidadDescripcion { 
            get 
            { return visivilidadDescripcion; } 
            set { visivilidadDescripcion = value;
                NotifyPropertyChanged("VisivilidadDescripcion");
            } } 
        public clsMisiones MisionSeleccionada
        {
            get
            {
                return misionSeleccionada;
            }
            set
            {
                misionSeleccionada = value;
                mostrarDescripcion.RaiseCanExecuteChanged();
            }
        }

        public ObservableCollection<clsMisiones> ListadoDeMisiones
        {
            get { return listadoDeMisiones; }
        }
        #endregion
        #region constructores
        public MisionesDisponibleVM()
        {
            //Cogemos el listado de la capa DAL
            listadoDeMisiones = new ObservableCollection<clsMisiones>(ListadoMisionesBL.obtenerListadoMisionesTotal());
            //Contruimos una mision vacia
            misionSeleccionada = null;
            visivilidadDescripcion=false;
        }

        
        #endregion
        /// <summary>
        /// Mostrara la descripcion de la mision
        /// </summary>
        private void MostrarDescripcion_Executed()
        {
            VisivilidadDescripcion=true;

            NotifyPropertyChanged("MisionSeleccionada");
        }
        /// <summary>
        /// Si la misionSeleccionada es nula devolvera 
        /// </summary>
        /// <returns></returns>
        private bool MostrarDescripcion_CanExecute()
        {
            bool botonValidar = true;
            if (misionSeleccionada == null)
            {
                botonValidar = false;
            }
            return botonValidar;
        }

        
    }
}
