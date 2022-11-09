namespace Entidades
{
    //Clase para mostrar las imagenes de la galería.
    public class clsImagenes
    {
        private String ruta;

        public String Ruta { get { return ruta; } set { ruta = value; } }

        public clsImagenes() { }

        public clsImagenes(string ruta)
        {
            Ruta = ruta;
        }
    }
}