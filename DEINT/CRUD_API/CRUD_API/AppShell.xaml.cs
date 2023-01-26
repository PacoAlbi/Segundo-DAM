using CRUD_Personas.Views;
namespace CRUD_API;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
        Routing.RegisterRoute("CrearPersona", typeof(CrearPersonaPage));
        Routing.RegisterRoute("CrearDepartamento", typeof(CrearDepartamentoPage));
        Routing.RegisterRoute("EditarPersona", typeof(EditarPersonasPage));
        Routing.RegisterRoute("EditarDepartamento", typeof(EditarDepartamentosPage));
        Routing.RegisterRoute("DetallesPersona", typeof(DetallesPersonaPage));
    }
}