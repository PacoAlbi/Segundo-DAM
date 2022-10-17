namespace _07_Pages;

using _07_Pages.Views.MenuFlyout;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();
        //MainPage = new FlyoutPageNavigation();
        MainPage = new NavigationPage(new MainPage());
    }
}
