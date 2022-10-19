using _07_Pages.Modelos;

namespace _07_Pages.Views;

public partial class Pagina4 : ContentPage
{
    public Pagina4() { InitializeComponent(); }

    public Pagina4(Persona persona)
	{
		InitializeComponent();

		lblPagina4.Text = $"Hola {persona.Name} {persona.Apellidos}";
		//lblPagina4.SetBinding(Label.ScaleProperty, new Binding("Text", source: nombre+" "+apellido));
	}
}