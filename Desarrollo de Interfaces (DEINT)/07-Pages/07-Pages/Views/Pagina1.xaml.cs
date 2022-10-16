namespace _07_Pages.Views;

public partial class Pagina1 : ContentPage
{
	public Pagina1()
	{
		InitializeComponent();
	}

    private async void OnCounterClicked(object sender, EventArgs e)
    {

        await Navigation.PushAsync(new _07_Pages.Views.Pagina1());

    }
}