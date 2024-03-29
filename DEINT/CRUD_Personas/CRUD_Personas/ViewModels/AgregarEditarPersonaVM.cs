﻿using BL.Listados;
using BL.Manejadoras;
using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;

namespace CRUD_Personas.ViewModels
{
    /// <summary>
    /// ViewModel para editar o crear personas.
    /// </summary>
    [QueryProperty("Persona", "personaParaMandar")]
    public class AgregarEditarPersonaVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand agregarCommand;
        private DelegateCommand editarCommand;
        private ObservableCollection<clsDepartamentos> listaDepartamentos;
        private clsPersona persona;
        private clsDepartamentos departamento;
        #endregion

        #region Contructores
        public AgregarEditarPersonaVM()
        {
            agregarCommand = new DelegateCommand(AgregarCommand_Executed);
            editarCommand = new DelegateCommand(EditarCommand_Executed);
            listaDepartamentos = new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosBL.getListadoDepartamentosBL());
            Persona= new clsPersona();
        }
        #endregion

        #region Propiedades
        public clsPersona Persona
        {
            get { return persona; }
            set { persona = value;
                //departamento = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(persona.idDepartamento); Con esto no me pilla el nombre, así que lo busco en la lista.
                departamento = listaDepartamentos.FirstOrDefault(x => x.id == persona.idDepartamento);
                NotifyPropertyChanged(nameof(Departamento));
                NotifyPropertyChanged(nameof(Persona));
            }
        }
        public clsDepartamentos Departamento
        {
            get { return departamento; }
            set { departamento = value; }
        }
        public ObservableCollection<clsDepartamentos> ListaDepartamentos
        {
            get { return listaDepartamentos; }
        }
        public DelegateCommand AgregarCommand { get { return agregarCommand; } }
        public DelegateCommand EditarCommand { get { return editarCommand; } }
        #endregion

        #region Commands
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando para agregar a la persona.
        /// Postcondiciones: Agregas a la persona en la BBDD.
        /// </summary>
        private async void AgregarCommand_Executed()
        {
            bool agregar = await App.Current.MainPage.DisplayAlert("¿Agregar persona?", null, "Si", "No");
            if (agregar)
            {
                try
                {
                    Persona.idDepartamento = Departamento.id;
                    NotifyPropertyChanged("Derpartamento");
                    clsManejadoraPersonas.insertarPersonasBL(Persona);
                    await Application.Current.MainPage.DisplayAlert("Persona insertada correctamente", null, "Ok");
                    await Shell.Current.GoToAsync("..");
                }
                catch (Exception)
                {
                    await Application.Current.MainPage.DisplayAlert("Alert!", "No se ha podido agregar a la persona", "Ok");
                }
            }
            else
            {
                await Shell.Current.GoToAsync("..");
            }           
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando para editar a la persona.
        /// Postcondiciones: Editas a la persona en la BBDD.
        /// </summary>
        private async void EditarCommand_Executed()
        {
            bool agregar = await App.Current.MainPage.DisplayAlert("¿Editar persona?", null, "Si", "No");
            if (agregar)
            {
                try
                {
                    Persona.idDepartamento = Departamento.id;
                    clsManejadoraPersonas.editarPersonaBL(Persona);
                    await Application.Current.MainPage.DisplayAlert("Persona editada correctamente", null, "Ok");
                    await Shell.Current.GoToAsync("..");
                }
                catch (Exception)
                {
                    await Application.Current.MainPage.DisplayAlert("Alert!", "No se ha podido editar a la persona", "Ok");
                }
            }
            else
            {
                await Shell.Current.GoToAsync("..");
            }
        }
        #endregion
    }
}