using _05_Hola_Mundo_WebForm.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace _05_Hola_Mundo_WebForm
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Evento asociado al clik del button1 que pilla el nombre y el apellido por textBox y saluda por pantalla, y si no hay alguno, muestra un mensaje de error
        /// Precondiciones: No tiene
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// Postcondiciones: No tiene
        protected void Button1_Click(object sender, EventArgs e)
        {

            clsPersona persona;

            if (string.IsNullOrEmpty(entryNombre.Text) || string.IsNullOrEmpty(entryApellido.Text))
            {

                texto.Text = "Debes introducir un nombre o un apellido";

            }else
            {
                
                persona = new clsPersona(entryNombre.Text, entryApellido.Text);
                texto.Text = $"Hola {persona.Nombre} {persona.Apellido}";

            }


        }
    }
}