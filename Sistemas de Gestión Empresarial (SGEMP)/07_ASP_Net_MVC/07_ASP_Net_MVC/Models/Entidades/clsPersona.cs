namespace _07_ASP_Net_MVC.Models.Entidades
{
    public class clsPersona
    {
        #region Atributos con Getter y Setter
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public DateOnly FechaNac { get; set; }
        public string Telefono { get; set; }
        public string Direccion { get; set; }
        public int idDepartamento { get; set; }
        #endregion

        #region Constructores
        public clsPersona()
        {
        }

        public clsPersona(int id, string nombre, string apellidos, int idDepartamento)
        {
            Id = id;
            Nombre = nombre;
            Apellidos = apellidos;
            this.idDepartamento = idDepartamento;
        }

        public clsPersona(string nombre, string apellidos)
        {
            Nombre = nombre;
            Apellidos = apellidos;
        }

        public clsPersona(string nombre, string apellidos, DateOnly fechaNac, string telefono, string direccion, int idDepartamento) : this(nombre, apellidos)
        {
            FechaNac = fechaNac;
            Telefono = telefono;
            Direccion = direccion;
            this.idDepartamento = idDepartamento;
        }
        #endregion
    }
}
