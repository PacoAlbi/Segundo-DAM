using Entidades;
using System.Collections.ObjectModel;

namespace DAL
{
    public class clsListadoImagenesDAL
    {

        public static ObservableCollection<clsImagenes> obtenerImagenes()
        {
            ObservableCollection<clsImagenes> lista = new ObservableCollection<clsImagenes>();
            lista.Add(new clsImagenes("tile_1.png"));
            lista.Add(new clsImagenes("tile_2.png"));
            lista.Add(new clsImagenes("tile_3.png"));
            lista.Add(new clsImagenes("tile_4.png"));
            lista.Add(new clsImagenes("tile_5.png"));
            lista.Add(new clsImagenes("tile_6.png"));
            lista.Add(new clsImagenes("tile_7.png"));
            lista.Add(new clsImagenes("tile_8.png"));
            return lista;
        }





    }
}