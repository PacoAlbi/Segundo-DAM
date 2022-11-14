using DAL;
namespace PlacasSolares.Views;

public partial class Citas : ContentPage
{
    /// <summary>
    /// Obtengo las im�genes para mostrar en la galer�a.
    /// </summary>
	public Citas()
	{
		InitializeComponent();
        lstImagenes.ItemsSource = clsListadoImagenesDAL.obtenerImagenes();
    }

    /// <summary>
    /// Bot�n que me lleva de las citas al Shell de cada cita.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void ImageButton_Clicked(object sender, EventArgs e)
    {
        Application.Current.MainPage = new AppShell();
    }

    /// <summary>
    /// Bot�n que me saca de la p�gina de citas a la del login, como si me deslogeara.
    /// </summary>
    /// <returns></returns>
    protected override bool OnBackButtonPressed()
    {
        Navigation.InsertPageBefore(new LoginPage(), Navigation.NavigationStack[0]);
        Navigation.RemovePage(Navigation.NavigationStack[1]);
        return base.OnBackButtonPressed();
    }

    /// <summary>
    /// Bot�n para ir al "destino" del trabajo, que abre la aplicaci�n de mapas del m�vil.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void abrirMapa(object sender, EventArgs e)
    {
        Map.Default.OpenAsync(new Location(37.36681850074017, -5.934129049246128), new MapLaunchOptions { NavigationMode = NavigationMode.Driving });
    }
}