using Mandaloriano_UI_MAUI.Views;

namespace Mandaloriano_UI_MAUI
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage = new MisionesDisponibles();
        }
    }
}