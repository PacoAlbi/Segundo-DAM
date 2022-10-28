using _07_Ejercicio123.Views;

namespace _07_Ejercicio123
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage = new NavigationPage(new MainPage());
        }
    }
}