using _08_Placas_Solares.Views;
namespace _08_Placas_Solares;

public partial class LoginPage : ContentPage
{

	public LoginPage()
	{
		InitializeComponent();
	}

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

