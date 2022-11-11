using DAL.Listas;
using Entidades;
using Mandaloriano_MAUI.ViewModels.Utilidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mandaloriano_MAUI.ViewModels
{
    public class VistaMisionesVM
    {
        #region Atributos
        private List<clsMision> listadoMisionesCompleto;
        private clsMision misionSeleccionada;
        private DelegateCommand mostrarDetallesCommand;
        private bool datosMisionEsVisible;
        #endregion

        #region Propiedades
        public List<clsMision> ListadoMisionesCompleto
        { get { return listadoMisionesCompleto; } }
        public clsMision MisionSeleccionada
        {
            get { return misionSeleccionada; }
            set { misionSeleccionada = value; }
        }
        public DelegateCommand MostrarDetallesCommand
        { get 
            {
                mostrarDetallesCommand = new DelegateCommand(MostrarDetalles_Executed, MostrarDetalles_CanExecuted);
                return mostrarDetallesCommand; 
            } }
        public bool DatosMisionEsVisible { get { return datosMisionEsVisible; } }
        #endregion

        #region Constructores
        #endregion

        #region Comandos
        /// <summary>
        /// private void MostrarDetalles_Executed()
        /// Método que muestra los detalles de la misión seleccionada haciendo visible el texto mediante el booleano datosMisionEsVisible.
        /// </summary>
        /// <exception cref="NotImplementedException"></exception>
        private void MostrarDetalles_Executed()
        {
            //throw new NotImplementedException();
        }
        /// <summary>
        /// private bool MostrarDetalles_CanExecuted()
        /// 
        /// </summary>
        /// <returns></returns>
        /// <exception cref="NotImplementedException"></exception>
        private bool MostrarDetalles_CanExecuted()
        {
            //throw new NotImplementedException();
            return true;
        }       
        #endregion

    }
}
