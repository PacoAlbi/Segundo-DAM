using PlacasSolares.Views;
namespace PlacasSolares;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
	}

    /// <summary>
    /// Botón para volver a la página de citas. 
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void vlvCitas_Clicked(object sender, EventArgs e)
    {
        Application.Current.MainPage = new Citas();
    }

    /// <summary>
    /// Botón para salir de la aplicación.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void MenuItem_Clicked(object sender, EventArgs e)
    {
        Application.Current.Quit();
    }
}
