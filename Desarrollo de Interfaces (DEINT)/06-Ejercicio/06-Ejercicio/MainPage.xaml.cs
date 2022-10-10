
namespace _06_Ejercicio;

public partial class MainPage : ContentPage
{


	public MainPage()
	{
		InitializeComponent();
	}

    private void btn2_Clicked(object sender, EventArgs e)
    {
        if (btn3.IsVisible == true)
        {
            btn3.IsVisible = false;
        }
        else
        {
            btn3.IsVisible = true;
        }


        Button btn;

        btn = new Button
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

    }

    private void btn3_Clicked(object sender, EventArgs e)
    {
        btn1.IsVisible = false;
        btn2.Text = "Crear controles mola como una gramola";
        btn2.WidthRequest = 400;
    }
}

