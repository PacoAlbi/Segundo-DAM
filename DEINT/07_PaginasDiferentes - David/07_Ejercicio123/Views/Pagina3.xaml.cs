namespace _07_Ejercicio123.Views;

public partial class Pagina3 : ContentPage
{
	public Pagina3()
	{
		InitializeComponent();
	}
    private async void irPaginaPrincipal(object sender, EventArgs e)
    {
        await Navigation.PopToRootAsync();
    }
}