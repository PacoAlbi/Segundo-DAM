namespace CRUD_Personas.Views;

public partial class VistaPersonasPage : ContentPage
{
	public VistaPersonasPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// M�todo para actualizar la vista despu�s de insertar o actualizar.
    /// </summary>
    protected override void OnAppearing()
    {
        InitializeComponent();
        base.OnAppearing();
    }
}