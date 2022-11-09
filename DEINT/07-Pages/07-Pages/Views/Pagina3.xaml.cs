namespace _07_Pages.Views;

public partial class Pagina3 : ContentPage
{
	public Pagina3()
	{
		InitializeComponent();
	}

    private async void btnVolverOrigen(object sender, EventArgs e)
    {
        await Navigation.PopToRootAsync();
    }
}