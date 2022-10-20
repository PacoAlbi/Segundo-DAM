using _07_ASP_Net_MVC.Models.Entidades;

namespace _07_ASP_Net_MVC.Models.DAL
{
    public class clsListadosPersonasDAL
    {
        /// <summary>
        /// 
        /// 
        /// </summary>
        /// <returns></returns>
        public static List<clsPersona> listadoPersonasCompleto () //Es candidata a ser estatica porque solo ofrece funcionalidades.
        {
            List<clsPersona> lista = new List<clsPersona>();
            lista.Add(new clsPersona("Paco","Albiñana"));
            lista.Add(new clsPersona("Eva","Ramos"));
            lista.Add(new clsPersona("Pepe","Gutierrez"));
            lista.Add(new clsPersona("Ana","Lopez"));
            lista.Add(new clsPersona("",""));
            lista.Add(new clsPersona("",""));

            return new List<clsPersona>();
        }
    }
}
