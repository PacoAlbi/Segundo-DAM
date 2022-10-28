using _07_PaginasDiferentes_TabbedPage;

namespace _07_PaginasDiferentes_TabbedPage.Views;

public partial class Pagina3 : ContentPage
{
	public Pagina3()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Este metodo creara una nueva instancia de la pagina principal, no podemos ver el texto que escribimos anteriormente ya que es una nueva
    /// instancia de la pagina principal, para ver el texto tendriamos que ir hacia atras en la navegation page
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void onClick(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new MainPage());

    }
}