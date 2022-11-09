using Microsoft.Maui.Controls;
using System.Text.Json;

namespace _08_Placas_Solares.Views;

class ImageList
{
    public List<string> Photos { get; set; }
}

public partial class Fotos : ContentPage
{
    HttpClient httpClient;
    JsonSerializerOptions serializerOptions;

    public Fotos()
	{
		InitializeComponent();
        httpClient = new HttpClient();
        serializerOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        };

        LoadBitmapCollection();
    }
    async void LoadBitmapCollection()
    {
        try
        {
            Uri uri = new Uri("https://raw.githubusercontent.com/xamarin/docs-archive/master/Images/stock/small/stock.json");
            HttpResponseMessage response = await httpClient.GetAsync(uri);
            if (response.IsSuccessStatusCode)
            {
                string content = await response.Content.ReadAsStringAsync();
                ImageList photos = JsonSerializer.Deserialize<ImageList>(content, serializerOptions);

                //Creamos un objeto imagen para cada Bitmap
                foreach (string photoUri in photos.Photos)
                {
                    Image image = new Image
                    {
                        Source = ImageSource.FromUri(new Uri(photoUri)),
                        HeightRequest = 100,
                        WidthRequest = 100
                    };
                    flexLayout.Children.Add(image);
                }
            }
        }
        catch
        {
            flexLayout.Children.Add(new Label
            {
                Text = "No se puede acceder a la lista de fotos."
            });
        }
        activityIndicator.IsRunning = false;
        activityIndicator.IsVisible = false;
    }
}