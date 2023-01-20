using System.Drawing;

namespace Entidades
{
    public class clsCirculo
    {
        #region Propiedades
        private string colores;
        private float xPosition;
        private float yPosition;
        #endregion

        #region Atributos
        public string Colores { get { return colores; } set { colores = value; } }
        public float XPosition { get { return xPosition; } set { xPosition = value; } }
        public float YPosition { get { return yPosition; } set { yPosition = value; } }
        #endregion

        #region Constructores
        public clsCirculo()
        {
            Random num = new Random();
            this.colores = Color.FromArgb(num.Next(255), num.Next(255), num.Next(255)).Name;
            this.xPosition= num.Next(800);
            this.yPosition = num.Next(800);
        }
        public clsCirculo(string color, float xPosition, float yPosition)
        {
            Colores = color;
            XPosition = xPosition;
            YPosition = yPosition;
        }
        #endregion
    }
}