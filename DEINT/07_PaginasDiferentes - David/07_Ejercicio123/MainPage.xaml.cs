using _07_Ejercicio123.Views;

namespace _07_Ejercicio123
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
        }
        private async void irTabbedPage(object sender, EventArgs e) {
            await Navigation.PushAsync(new PaginaTabbed());
        }

        private async void irPagina4(object sender, EventArgs e)
        {
            Persona persona;
            if (String.IsNullOrEmpty(txtNombre.Text))
            {
                txtNombre.Text = "";
            }
            if (String.IsNullOrEmpty(txtApellido.Text))
            {
                txtApellido.Text = "";
            }
            persona = new Persona(txtNombre.Text, txtApellido.Text);
            await Navigation.PushAsync(new Pagina4(persona));
        }
        private async void irPagina5(object sender, EventArgs e)
        {
            Persona persona;
            if (String.IsNullOrEmpty(txtNombre.Text))
            {
                txtNombre.Text = "";
            }
            if (String.IsNullOrEmpty(txtApellido.Text))
            {
                txtApellido.Text = "";
            }
            persona = new Persona(txtNombre.Text, txtApellido.Text);
            await Navigation.PushAsync(new Pagina5 { BindingContext=persona});
        }

    }
}