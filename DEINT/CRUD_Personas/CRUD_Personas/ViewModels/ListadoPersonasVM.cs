using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRUD_Personas.ViewModels
{
    public class ListadoPersonasVM : clsVMBase
    {
        #region Atributos
        public ObservableCollection<clsPersona> listaPersonasCompleta { get; set; }



        public ListadoPersonasVM() { }


    }
}
