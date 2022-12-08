using CRUD_Personas.Views;

namespace CRUD_Personas;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
		//Registro las rutas de todas las páginas de navegacion que no pertenecen al tab
        Routing.RegisterRoute("CrearPersona", typeof(CrearPersonaPage)); //TODO colocar todas las paginas aqui que no estén en los tabs
        Routing.RegisterRoute("CrearDepartamento", typeof(CrearDepartamentoPage));
        Routing.RegisterRoute("EditarPersona",typeof(EditarPersonasPage));
		Routing.RegisterRoute("EditarDepartamento",typeof(EditarDepartamentosPage));
		Routing.RegisterRoute("DetallesPersona",typeof(DetallesPersonaPage));
	}
}
