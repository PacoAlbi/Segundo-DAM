namespace CRUD_Personas.Views;

public partial class VistaPersonasPage : ContentPage
{
	public VistaPersonasPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Precondiciones: No tiene.
    /// M�todo para actualizar la vista despu�s de insertar o actualizar.
    /// Postcondiciones: No tiene.
    /// </summary>
    protected override void OnAppearing()
    {
        InitializeComponent();
        base.OnAppearing();
    }
}