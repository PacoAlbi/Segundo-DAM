using PlacasSolares.Views;
namespace PlacasSolares;

public partial class LoginPage : ContentPage
{

	public LoginPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Compruebo que el usuario meta nombre y contraseña antes de entrar en el sistema. Si no lanzo un mensaje de advertencia.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void btnLog_Clicked(object sender, EventArgs e)
    {
        if (nombre.Text is not null && password.Text is not null)
        {
            await Navigation.PushAsync(new Citas());
        }
        else
        {
            DisplayAlert("Advertencia", "Debe introducir nombre y pasworrd", "OK");
        }
    }
}

