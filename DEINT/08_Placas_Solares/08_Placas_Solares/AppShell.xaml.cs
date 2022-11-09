using _08_Placas_Solares.Views;
namespace _08_Placas_Solares;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
	}

	private void vlvCitas_Clicked(object sender, EventArgs e)
	{
        Application.Current.MainPage = new Citas();
    }

	private void MenuItem_Clicked(object sender, EventArgs e)
	{
        Application.Current.Quit();
    }
}
