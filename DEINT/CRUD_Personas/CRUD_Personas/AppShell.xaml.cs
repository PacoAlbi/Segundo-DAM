using CRUD_Personas.Views;

namespace CRUD_Personas;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
        Routing.RegisterRoute("CrearPersona", typeof(EditarPersonasPage)); //TODO colocar todas las paginas aqui
        Routing.RegisterRoute("CrearDepartamento", typeof(EditarDepartamentosPage));
        Routing.RegisterRoute("EditarPersona",typeof(EditarPersonasPage));
		Routing.RegisterRoute("EditarDepartamento",typeof(EditarDepartamentosPage));
	}
}
