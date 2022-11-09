using System.ComponentModel.DataAnnotations;

namespace _08_ASP_MVC_Ejercicio3.Models.Entidades
{
    /// <summary>
    /// Creacion de la clase persona con sus atributos privados, sus propiedades publicas y sus constructores
    /// </summary>
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        private string primerApellido;
        private string segundoApellido;
        private int edad;

        #endregion

        #region Propiedades
        [Required(ErrorMessage = "Campo obligatorio")]
        public string Nombre { get { return nombre; } set { nombre = value; } }
        public string PrimerApellido { get { return primerApellido; } set { primerApellido = value; } }
        public string SegundoApellido { get { return segundoApellido; } set { segundoApellido = value; } }
        public int Edad { get { return edad; } set { edad = value; } }

        #endregion

        #region Constructores

        public clsPersona()
        {
            this.nombre = "Paco";
            this.primerApellido = "Albiñana";
            this.segundoApellido = "Ruiz";
            this.edad = 42;
            
        }
         
        public clsPersona(string nombre, string apellido1, string apellido2, int edad)
        {
            Nombre = nombre;
            PrimerApellido = apellido1;
            SegundoApellido = apellido2;
            Edad = edad;
           
        }



        #endregion
    }
}
