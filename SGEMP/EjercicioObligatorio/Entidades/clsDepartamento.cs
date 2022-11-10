namespace Entidades
{
    public class clsDepartamento
    {
        public int IdDepartamento { get; set; }

        public String NombreDepartamento { get; set; }

        public clsDepartamento(int idDepartamento, string nombreDepartamento)
        {
            IdDepartamento = idDepartamento;
            NombreDepartamento = nombreDepartamento;
        }

        public clsDepartamento()
        {

        }
    }
}
