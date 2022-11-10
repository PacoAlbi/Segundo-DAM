using System.ComponentModel.DataAnnotations;

namespace Entidades
{
    /// <summary>
    /// Creacion de la clase persona con sus atributos privados, sus propiedades publicas y sus constructores
    /// </summary>
    public class clsPersona
    {
        #region Atributos
        private int idPersona;
        private string nombre;
        private string primerApellido;
        private string segundoApellido;
        private DateOnly fechaNac;
        private String direccion;
        private String telefono;
        private int edad;
        #endregion

        #region Propiedades
        public int IdPersona { get { return idPersona; } set { idPersona = value; } } 
        [Required(ErrorMessage = "Campo obligatorio")]
        public String Nombre { get { return nombre; } set { nombre = value; } }
        [MaxLength(40),Required(ErrorMessage = "Campo obligatorio")]
        public String PrimerApellido { get { return primerApellido; } set { primerApellido = value; } }
        [MaxLength(40), Required(ErrorMessage = "Campo obligatorio")]
        public String SegundoApellido { get { return segundoApellido; } set { segundoApellido = value; } }
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:d}")]
        public DateOnly FechaNac { get { return fechaNac; } set { fechaNac = value; } }
        [MaxLength(200)]
        public String Direccion { get { return direccion; } set { direccion = value; } }
        [RegularExpression("[0-9]{3}\\s[0-9]{3}\\s[0-9]{3}", ErrorMessage = "Debe cumplir el formato *** *** *** de teléfono")]
        public String Telefono { get { return telefono; } set { telefono = value; } }
        public int Edad { get { return edad; } set { edad = value; } }
        #endregion

        #region Constructores
        public clsPersona()
        {
            this.idPersona = 6;
            this.nombre = "Paco";
            this.primerApellido = "Albiñana";
            this.segundoApellido = "Ruiz";
            this.fechaNac = new DateOnly(1980,05,05);
            this.Direccion = "Sevilla la Linda toa ella.";
            this.telefono = "616 058 828";
            this.edad = 42;
        }

        public clsPersona(string nombre, string apellido1, string apellido2, int edad, DateOnly fecha, String dir, String telf)
        {
            this.nombre = nombre;
            this.primerApellido = apellido1;
            this.segundoApellido = apellido2;
            this.fechaNac = fecha;
            this.direccion = dir;
            this.telefono = telf;
            this.edad = edad;
        }
        #endregion
    }
}