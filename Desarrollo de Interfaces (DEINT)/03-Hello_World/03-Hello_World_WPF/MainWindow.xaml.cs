using _03_Hello_World_Entidades_Estandar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _03_Hello_World_WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();        
        }

        /// <summary>
        /// prototipo: private void btnAccion_Click(object sender, RoutedEventArgs e)
        /// comentarios: Evento asociado al botón click saludar. Mostrará por pantalla el nombre de la persona escrito en una ventana a parte.
        /// precondiones: No tiene.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// postcondiciones: No devuelve nada ya que es un evento.

        private void btnAccion_Click(object sender, RoutedEventArgs e)
        {
            clsPersona usuario = new clsPersona();
            usuario.Nombre = textBox.Text;

            if (usuario.Nombre == null || usuario.Nombre.Equals("") || usuario.Nombre.StartsWith(" "))
            {

                lblerror.Visibility = Visibility.Visible;

            }else
            {
                MessageBox.Show($"Hola {usuario.Nombre}");
            }           
        }
    }
}
