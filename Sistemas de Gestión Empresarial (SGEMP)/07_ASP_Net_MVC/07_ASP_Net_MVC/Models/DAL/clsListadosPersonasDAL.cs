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
            lista.Add(new clsPersona(1,"Paco","Albiñana",4));
            lista.Add(new clsPersona(2,"Eva","Ramos",6));
            lista.Add(new clsPersona(3,"Pepe","Gutierrez",6));
            lista.Add(new clsPersona(4,"Ana","Lopez",1));
            lista.Add(new clsPersona(5,"Manuel","Lopez",2));
            lista.Add(new clsPersona(6,"Fatima","Hamida",3));

            return lista;
        }
    }
}
