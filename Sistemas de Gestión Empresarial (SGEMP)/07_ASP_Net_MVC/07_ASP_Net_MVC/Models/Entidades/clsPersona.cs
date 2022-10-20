namespace _07_ASP_Net_MVC.Models.Entidades
{
    public class clsPersona
    {
        private string _nombre;
        private string _apellidos;
        private DateOnly _fechaNac;
        private string _telefono;
        private string _direccion;

        public string Name { get; set; }
        public string Apellidos { get; set; }
        public DateOnly FechaNac { get; set; }
        public string Telefono { get; set; }
        public string Direccion { get; set; }

        public clsPersona()
        {
        }

        public clsPersona(string nombre, string apellidos)
        {
            _nombre = nombre;
            _apellidos = apellidos;
        }

        public clsPersona(string nombre, string apellidos, DateOnly fechaNac, string telefono, string direccion)
        {
            _nombre = nombre;
            _apellidos = apellidos;
            _fechaNac = fechaNac;
            _telefono = telefono;
            _direccion = direccion;
        }
    }
}
