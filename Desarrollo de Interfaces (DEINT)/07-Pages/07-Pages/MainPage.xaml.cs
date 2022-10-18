using _07_Pages.Modelos;
using _07_Pages.Views;
using Microsoft.Maui.Controls;

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
        await Navigation.PushAsync(new PaginaTabbed());
	}

    private async void OnCounterClicked4(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Pagina4());
        
    }

    private async void OnCounterClicked5(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Pagina5{ BindingContext = persona });
    }
}