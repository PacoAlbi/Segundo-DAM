using _05_Entidades;

namespace _05_Hola_Mundo_1;

public partial class MainPage : ContentPage
{
	int count = 0;

	public MainPage()
	{
		InitializeComponent();
	}

	private void OnCounterClicked(object sender, EventArgs e)
	{
		clsPersona persona = new clsPersona();

		
		/*if (string.IsNullOrEmpty(persona.Nombre = entryNombre.Text))
		{
			persona.Nombre = DisplayPromptAsync("Perdona", "No has dicho tu nombre");

        }*/



		if (string.IsNullOrEmpty(persona.Nombre = entryNombre.Text) || string.IsNullOrEmpty(persona.Apellido = entryApellido.Text))
		{

			DisplayAlert("Alerta", "Debes introducir un nombre y un apellido", "OK");

        }
        else
		{
			DisplayAlert("Saludo", $"Hola {persona.Nombre} {persona.Apellido}", "Saludado");
		}


		/*
		count++;

		if (count == 1)
			CounterBtn.Text = $"Clicked {count} time";
		else
			CounterBtn.Text = $"Clicked {count} times";

		SemanticScreenReader.Announce(CounterBtn.Text);*/
	}
}

