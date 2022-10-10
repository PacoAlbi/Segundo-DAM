
namespace _06_Ejercicio;

public partial class MainPage : ContentPage
{

    /// <summary>
    /// Evento principal que inicializa los componenetes.
    /// Precondiciones: No tiene
    /// Postcondiciones: No tiene
    /// </summary>
	public MainPage()
	{
		InitializeComponent();
	}

    /// <summary>
    /// Precondiciones: No tiene
    /// Evento asociado al click del botón 2, que cada vez que lo pulsas te crea un nuevo botón.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    /// Postcondiciones: Genera un nuevo botón cada vez.
    private void btn2_Clicked(object sender, EventArgs e)
    {
        
        Button btn = new Button
        {
            Text = "Boton4",
            BackgroundColor = Colors.Blue,
            WidthRequest = 200,
            HeightRequest = 70,
            HorizontalOptions = LayoutOptions.Center,
            VerticalOptions = LayoutOptions.Center,
            FontSize = 16,
            FontAttributes = FontAttributes.Bold,
            BorderColor = Colors.Yellow,
            Margin = 30,
        };

        btn.Clicked += btn3_Clicked;
        layout.Children.Add(btn);
    }

    /// <summary>
    /// Precondiciones: No tiene
    /// Evento asociado al click del botón 3, que cuando lo pulsas, elimina el botón 1 y cambia el texto del botón 2
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    /// Postcondiciones: Genera un nuevo botón cada vez.
    private void btn3_Clicked(object sender, EventArgs e)
    {
        layout.Children.Remove(btn1);
        btn2.Text = "Crear controles mola como una gramola";
        btn2.WidthRequest = 400;
    }
}

