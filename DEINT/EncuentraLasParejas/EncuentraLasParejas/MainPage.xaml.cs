namespace EncuentraLasParejas;

public partial class MainPage : ContentPage
{
	public MainPage()
	{
		InitializeComponent();
	}

    private async void navegarTablero (object sender, EventArgs e)
    {
        await Shell.Current.GoToAsync("Tablero");
    }
    private async void navegarRanking(object sender, EventArgs e)
    {
        await Shell.Current.GoToAsync("Tablero");
    }
}

