using CRUD_API.ViewModels;

namespace CRUD_Personas.Views;

public partial class VistaDepartamentosPage : ContentPage
{
	public VistaDepartamentosPage()
	{
		InitializeComponent();
	}
    /// <summary>
    /// Hago la llamada al constructor de forma as�ncrona y le paso el ViewModel a la vista por aqui.
    /// </summary>
    protected override async void OnAppearing()
    {
        VistaDepartamentosVM viewModel = await VistaDepartamentosVM.BuildViewModelAsync();
        this.BindingContext = viewModel;
        InitializeComponent();
        base.OnAppearing();
    }
}