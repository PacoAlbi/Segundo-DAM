namespace _07_ASP_Net_MVC.Models.Entidades
{
    public class clsDepartamento
    {
        public string NombreDepartamento { get; set; }
        public int IdDepartamento { get; set; }

        public clsDepartamento()
        {
        }

        public clsDepartamento(string nombreDepartamento, int idDepartamento)
        {
            NombreDepartamento = nombreDepartamento;
            IdDepartamento = idDepartamento;
        }
    }
}
