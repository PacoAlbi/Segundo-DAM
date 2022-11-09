using DAL;
namespace _08_Placas_Solares.Views;

public partial class Citas : ContentPage
{
	public Citas()
	{
		InitializeComponent();
		lstImagenes.ItemsSource = clsListadoImagenesDAL.obtenerImagenes();
	}

	private void ImageButton_Clicked(object sender, EventArgs e)
	{
        Application.Current.MainPage = new AppShell();
    }

    protected override bool OnBackButtonPressed()
    {
        Navigation.InsertPageBefore(new LoginPage(), Navigation.NavigationStack[0]);
        Navigation.RemovePage(Navigation.NavigationStack[1]);
        return base.OnBackButtonPressed();
    }
}