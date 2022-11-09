
using System.Security.AccessControl;

namespace _07_PaginasDiferentes_NavigationPage
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
        }
        /// <summary>
        /// Metoro que creara una nueva instancia de PaginaTabbed con la accion de clickar el boton btnTabbedPage
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private async void tabbedPage(object sender, EventArgs e)
        {
            string nombre;
            if (txtNada.Text != null)
            {

                nombre = txtNada.Text;
            }
            else
            {
                nombre = "";
            }
            Persona persona = new Persona
            {
                Nombre = nombre
            };

            await Navigation.PushAsync(new _07_PaginasDiferentes_TabbedPage.Views.PaginaTabbed());
        }
    }
}