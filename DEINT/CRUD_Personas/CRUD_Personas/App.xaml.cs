using CRUD_Personas.Views;

namespace CRUD_Personas;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new ListadoPersonas();
	}
}
