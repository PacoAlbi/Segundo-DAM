namespace Entidades
{
    // All the code in this file is included in all platforms.
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