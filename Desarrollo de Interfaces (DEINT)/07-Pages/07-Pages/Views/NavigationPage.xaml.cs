namespace _07_Pages.Views;

public partial class NavigationPage : ContentPage
{
	
	private MainPage mainPage;
    private Page page;

    public NavigationPage()
	{
		InitializeComponent();
		
	}

    private async void OnCounterClicked(object sender, EventArgs e)
    {

        await Navigation.PushAsync(new PaginaTabbed());

    }

}