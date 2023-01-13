namespace Entidades
{
    public class Carta
    {
        #region Atributos
        private int id;
        private string anverso;
        private string reverso;
        #endregion

        #region Propiedades
        public int Id { get { return id; } set { id = value; } }
        public string Anverso { get { return anverso; } set { anverso = value; } }
        public string Reverso { get { return reverso; } set { reverso = value; } }
        #endregion

        #region Constructores
        public Carta() { }
        public Carta(int id, string anverso, string reverso)
        {
            Id = id;
            Anverso = anverso;
            Reverso = reverso;
        }
        public Carta(Carta carta)
        {
            Id = carta.Id;
            anverso= carta.Anverso;
            reverso= carta.Reverso;
        }
        #endregion

    }
}