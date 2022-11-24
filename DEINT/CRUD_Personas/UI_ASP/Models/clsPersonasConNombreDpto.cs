﻿using BL;
using BL.Listados;
using DAL.Listados;
using Entidades;

namespace UI_ASP.Models
{
    public class clsPersonasConNombreDpto: clsPersona
    {
        #region Atributos
        private string nombreDpto;
        #endregion

        #region Propiedades
        public string NombreDpto { get { return nombreDpto;} set { nombreDpto = value;} }
        #endregion

        #region Constructor
        public clsPersonasConNombreDpto() { }
        #endregion
    }
}
