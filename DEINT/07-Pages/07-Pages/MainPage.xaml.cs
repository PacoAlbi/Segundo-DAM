using _07_Pages.Modelos;
using _07_Pages.Views;
using Microsoft.Maui.Controls;

namespace _07_Pages;

public partial class MainPage : ContentPage
{

    public MainPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// 
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
	private async void OnCounterClicked(object sender, EventArgs e)
	{
        await Navigation.PushAsync(new PaginaTabbed());
	}
    /// <summary>
    /// 
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void OnCounterClicked4(object sender, EventArgs e)
    {
        Persona persona = new Persona();
        persona.Name = entryNombre.Text;
        persona.Apellidos = entryApellidos.Text;
        await Navigation.PushAsync(new Pagina4(persona));
        //await Navigation.PushAsync(new PaginaTabbed { BindingContext = persona});
    }
    /// <summary>
    /// 
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void OnCounterClicked5(object sender, EventArgs e)
    {
        Persona persona = new Persona();
        persona.Name = entryNombre.Text;
        persona.Apellidos = entryApellidos.Text;
        await Navigation.PushAsync(new Pagina5{ BindingContext = persona });
    }
}