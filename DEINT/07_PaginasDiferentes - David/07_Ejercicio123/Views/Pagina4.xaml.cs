namespace _07_Ejercicio123.Views;

public partial class Pagina4 : ContentPage
{
	public Pagina4(Persona persona)
	{
		InitializeComponent();
		lblNombre.Text = $"{lblNombre.Text} {persona.Name} {persona.Apellido}";
	}
}