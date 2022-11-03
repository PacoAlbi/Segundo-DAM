namespace _08_Placas_Solares;

public partial class MainPage : ContentPage
{


	public MainPage()
	{
		InitializeComponent();
	}

	private async void btnLog_Clicked(object sender, EventArgs e)
	{
		if (nombre.Text is not null && password.Text is not null)
		{
            await Navigation.PushAsync(new AppShell());
        }
        else
        {
            DisplayAlert("Advertencia", "Debe introducir nombre y pasworrd", "OK");
        }
    }
}

