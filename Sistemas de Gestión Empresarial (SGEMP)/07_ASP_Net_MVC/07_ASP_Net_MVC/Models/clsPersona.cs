namespace _07_ASP_Net_MVC.Models
{
    public class clsPersona
    {
        private String _nombre;
        private String _apellidos;
        private DateOnly _fechaNac;
        private String _telefono;
        private String _direccion;

        public clsPersona()
        {
        }

        public clsPersona(string nombre, string apellidos, DateOnly fechaNac, String telefono, string direccion)
        {
            _nombre = nombre;
            _apellidos = apellidos;
            _fechaNac = fechaNac;
            _telefono = telefono;
            _direccion = direccion;
        }

        public String Name { get; set; }
        public String Apellidos { get; set; }
        public DateOnly FechaNac { get; set; }
        public string Telefono { get; set; }
        public string Direccion { get; set; }
    }
}
