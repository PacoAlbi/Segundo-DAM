using DAL;
namespace PlacasSolares.Views;

public partial class Citas : ContentPage
{
    /// <summary>
    /// Obtengo las imágenes para mostrar en la galería.
    /// </summary>
	public Citas()
	{
		InitializeComponent();
        lstImagenes.ItemsSource = clsListadoImagenesDAL.obtenerImagenes();
    }

    /// <summary>
    /// Botón que me lleva de las citas al Shell de cada cita.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void ImageButton_Clicked(object sender, EventArgs e)
    {
        Application.Current.MainPage = new AppShell();
    }

    /// <summary>
    /// Botón que me saca de la página de citas a la del login, como si me deslogeara.
    /// </summary>
    /// <returns></returns>
    protected override bool OnBackButtonPressed()
    {
        Navigation.InsertPageBefore(new LoginPage(), Navigation.NavigationStack[0]);
        Navigation.RemovePage(Navigation.NavigationStack[1]);
        return base.OnBackButtonPressed();
    }

    /// <summary>
    /// Botón para ir al "destino" del trabajo, que abre la aplicación de mapas del móvil.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void abrirMapa(object sender, EventArgs e)
    {
        Map.Default.OpenAsync(new Location(37.36681850074017, -5.934129049246128), new MapLaunchOptions { NavigationMode = NavigationMode.Driving });
    }
}