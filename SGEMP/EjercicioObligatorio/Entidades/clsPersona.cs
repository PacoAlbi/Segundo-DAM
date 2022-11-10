namespace Entidades
{
    public class clsPersona
    {

        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public int Edad { get; set; }
        public int IdDepartamento { get; set; }

        public clsPersona(string nombre, string apellido, int edad, int idDepartamento)
        {
            Nombre = nombre;
            Apellido = apellido;
            Edad = edad;
            IdDepartamento = idDepartamento;
        }

        public clsPersona()
        {

        }
    }
}


