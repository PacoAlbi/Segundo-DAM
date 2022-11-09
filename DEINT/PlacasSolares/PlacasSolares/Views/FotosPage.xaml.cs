using System.Text.Json;

namespace PlacasSolares.Views;

/// <summary>
/// Clase para hacer una lista de las fotos de la galería.
/// </summary>
class ImageList
{
    public List<string> Photos { get; set; }
}

public partial class Fotos : ContentPage
{
    HttpClient httpClient;
    JsonSerializerOptions serializerOptions;
    /// <summary>
    /// Aquí instancio y llamo al método.
    /// </summary>
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
    /// <summary>
    /// Carga los bitmaps de un json con las direcciones en internet y los muestra en la galería.
    /// </summary>
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

    /// <summary>
    /// Método para hacer una foto y guardarla en la galería, en el informe.
    /// </summary>
    public async void HacerFoto()
    {
        if (MediaPicker.Default.IsCaptureSupported)
        {
            FileResult photo = await MediaPicker.Default.CapturePhotoAsync();

            if (photo != null)
            {
                // save the file into local storage
                string localFilePath = Path.Combine(FileSystem.CacheDirectory, photo.FileName);
                ImageButton image = new ImageButton
                {
                    Source = ImageSource.FromFile(localFilePath),
                    HeightRequest = 100,
                    WidthRequest = 100
                };

                bool answer = await DisplayAlert("Guardar", "¿Incluir al informe?", "Si", "No");

                if (answer)
                {
                    flexLayout.Children.Add(image);
                }
                //Aqui se debería preguntar al usuario si nquiere añadir la foto


                //Aqui se guarda la foto en la memoria interna
                using Stream sourceStream = await photo.OpenReadAsync();
                using FileStream localFileStream = File.OpenWrite(localFilePath);

                await sourceStream.CopyToAsync(localFileStream);
            }
        }
    }
    /// <summary>
    /// Botón que llama al método de hacer fotos.
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private void btnFoto_Clicked(object sender, EventArgs e)
    {
        HacerFoto();
    }
}