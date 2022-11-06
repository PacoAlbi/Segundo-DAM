namespace _08_Placas_Solares;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		//MainPage = new NavigationPage(new MainPage());
        MainPage = new AppShell();
    }
}
