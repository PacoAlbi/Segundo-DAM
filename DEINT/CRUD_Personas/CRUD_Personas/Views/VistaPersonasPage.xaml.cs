using CRUD_Personas.ViewModels;

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
    protected override async void OnAppearing()
    {
        InitializeComponent();
        this.BindingContext = await VistaPersonasVM.BuildViewModelAsync();
        //((VistaPersonasVM)(this.BindingContext)).actualizarLista(); Falta hacer el metodo acturalizar lista
        base.OnAppearing();
    }
}