namespace CRUD_Personas.Views;

public partial class VistaDepartamentosPage : ContentPage
{
	public VistaDepartamentosPage()
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