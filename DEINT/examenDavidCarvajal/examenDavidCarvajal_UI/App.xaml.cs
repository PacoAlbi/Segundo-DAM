namespace examenDavidCarvajal_UI;
using examenDavidCarvajal_UI.View;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new VistaTableroCartas();
	}
}
