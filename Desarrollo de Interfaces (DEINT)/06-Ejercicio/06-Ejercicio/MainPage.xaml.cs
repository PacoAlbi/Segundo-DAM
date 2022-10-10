
namespace _06_Ejercicio;

public partial class MainPage : ContentPage
{
    //bool existeBtn3 = false;

    Button btn;
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
    private void btnBoton2_Clicked(object sender, EventArgs e)
    {

        String a = vslBotones.Children.Contains(btn) == true ? "Existe" : "No existe";

        if (a == "Existe")
        {
            DisplayAlert("Alerta","Ya hay muchos botones","Ok");
        }else
        {

            crearBoton3();
            
        }
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
        vslBotones.Children.Remove(btnBoton1);
        btnBoton2.Text = "Crear controles mola como una gramola";
        btnBoton2.WidthRequest = 400;
    }

    private void crearBoton3()
    {

        btn = new Button
        {

            Text = $"Boton 3",
            BackgroundColor = Colors.Blue,
            WidthRequest = 200,
            HeightRequest = 70,
            HorizontalOptions = LayoutOptions.Center,
            VerticalOptions = LayoutOptions.Center,
            FontSize = 16,
            FontAttributes = FontAttributes.Bold,
            BorderColor = Colors.Yellow,
            BorderWidth = 10,
            Margin = 30,
        };

        //existeBtn3 = true;
        btn.Clicked += btn3_Clicked;
        vslBotones.Children.Add(btn);

    }

}

