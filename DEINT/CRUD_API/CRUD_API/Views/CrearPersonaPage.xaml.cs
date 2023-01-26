using CRUD_API.ViewModels;

namespace CRUD_Personas.Views;

public partial class CrearPersonaPage : ContentPage
{
	public CrearPersonaPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Hago la llamada al constructor de forma as�ncrona y le paso el ViewModel a la vista por aqui.
    /// </summary>
    protected override async void OnAppearing()
    {
        AgregarEditarPersonaVM viewModel = await AgregarEditarPersonaVM.BuildViewModelAsync();
        this.BindingContext = viewModel;
        InitializeComponent();
        base.OnAppearing();
    }
}