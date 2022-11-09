using _07_PaginasDiferente_FlyoutPage.Views.MenuFlyout;

namespace _07_PaginasDiferente_FlyoutPage
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage = new FlyoutPageNavigation();
        }
    }
}