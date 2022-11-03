namespace _09_Ejercicio1;

public partial class MainPage : ContentPage
{

	public MainPage()
	{
		InitializeComponent();
	}

	private void entry_TextChanged(object sender, TextChangedEventArgs e)
	{
		if (entry.Text == "")
		{
			entry.Text = "1";
		}else
		{
            double entrada = Convert.ToDouble(entry.Text);
            int entero = Convert.ToInt32(entrada);
            entry.Text = Convert.ToString(entero);
        }
	}
}

