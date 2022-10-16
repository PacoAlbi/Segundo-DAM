namespace _07_Pages;

public partial class MainPage : ContentPage
{


	public MainPage()
	{
		InitializeComponent();
	}

	private async void OnCounterClicked(object sender, EventArgs e)
	{

        await Navigation.PushAsync(new _07_Pages.Views.Pagina1());

	}
}

