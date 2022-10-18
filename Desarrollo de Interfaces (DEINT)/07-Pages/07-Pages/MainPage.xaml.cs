using _07_Pages.Modelos;

namespace _07_Pages;

public partial class MainPage : ContentPage
{
    Persona persona = new();

    public MainPage()
	{
		InitializeComponent();
        entryNombre.BindingContext = persona.Name;
        entryApellidos.BindingContext = persona.Apellidos;
	}

	private async void OnCounterClicked(object sender, EventArgs e)
	{
        await Navigation.PushAsync(new Views.PaginaTabbed());
	}

    private async void OnCounterClicked4(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Views.Pagina4());
        
    }

    private async void OnCounterClicked5(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Views.Pagina5());
    }
}