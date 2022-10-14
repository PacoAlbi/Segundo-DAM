using _07_Pages.Views;

namespace _07_Pages;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new PaginaTabbed();
	}
}
