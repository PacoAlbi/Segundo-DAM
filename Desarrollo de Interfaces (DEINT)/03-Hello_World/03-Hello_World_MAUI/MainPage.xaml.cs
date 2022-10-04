using _03_Hello_World_Entidades_Estandar;

namespace _03_Hello_World_MAUI
{
    public partial class MainPage : ContentPage
    {
        int count = 0;

        public MainPage()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Evento asociado al clik del boton OnCounterClicked que valida del nombre.
        /// Precondición: Ninguna
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// Postcondición: Ninguna

        private void OnCounterClicked(object sender, EventArgs e)
        {


            clsPersona persona;

            if (txtNombre.Text == null || txtNombre.Text == "")  //(String.IsNullOrEmpty(txtNombre.Text))
            {

                txtError.IsVisible = true;

            }
            else
            {

                persona = new clsPersona(entrada.Text);
                txtError.IsVisible = false;
                DisplayAlert("Saludo", $"Hola {persona.Nombre}", "Queda usted saludado" );

            }

        }



        /*
        private void OnCounterClicked(object sender, EventArgs e)
        {

            
            clsPersona persona;

            if (txtNombre.text == null || txtNombre == "")  //(String.IsNullOrEmpty(txtNombre.Text))
            {

                txtError.IsVisible = true;

            } else
            {

                persona = new clsPersona(txtNombre.Text);
                txtError.IsVisible = false;
                DisplayAlert("Saludos", $" Hola {persona.Nombre}, "GO" );

            }

            
            count++;

            if (count == 1)
                CounterBtn.Text = $"Clicked {count} time";
            else
                CounterBtn.Text = $"Clicked {count} times";

            SemanticScreenReader.Announce(CounterBtn.Text);
            
        }*/
    }
}