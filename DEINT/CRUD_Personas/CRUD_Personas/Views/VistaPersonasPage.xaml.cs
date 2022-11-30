namespace CRUD_Personas.Views;

public partial class VistaPersonasPage : ContentPage
{
	public VistaPersonasPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Método para actualizar la vista después de insertar o actualizar.
    /// </summary>
    protected override void OnAppearing()
    {
        InitializeComponent();
        base.OnAppearing();
    }
}