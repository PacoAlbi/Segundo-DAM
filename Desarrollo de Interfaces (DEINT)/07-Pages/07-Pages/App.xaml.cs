using _07_Pages.Views;
using NavigationPage = _07_Pages.Views.NavigationPage;

namespace _07_Pages;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();
        MainPage = new NavigationPage(new MainPage());
        
    }
}
