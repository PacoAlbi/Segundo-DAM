namespace _07_Pages.Views;

public partial class NavigationPage : ContentPage
{
	
	private MainPage mainPage;

	public NavigationPage()
	{
		InitializeComponent();
		
	}
	public NavigationPage(MainPage mainPage)
	{
		this.mainPage = mainPage;
	}

    private async void OnCounterClicked(object sender, EventArgs e)
    {

        await Navigation.PushAsync(new _07_Pages.Views.Pagina1());

    }

}