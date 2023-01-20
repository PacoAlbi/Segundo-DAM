using Entidades;
using Microsoft.AspNetCore.SignalR.Client;

namespace CirculosUI
{
    public partial class MainPage : ContentPage
    {
        private readonly HubConnection miConexion;

        public MainPage()
        {
            clsCirculo circulo= new clsCirculo();
            InitializeComponent();
            DibujarCirculo(circulo);

            //Me he quedado aqui, porque no se porque no me coge ahora el metodo para conectar al Hub y ya no se como arreglarlo, ni tanpoco me ha dado tiempo 
            // a hacerte todos los sumarys, la verdad que ni uno, pero me ha quedado bien como quedaba
            miConexion = new HubConnectionBuilder().WithUrl("http://localhost:5005/HubCirculos").Build();

            miConexion.On<clsCirculo>("DibujarCirculo", (circulo) =>
            {
                DibujarCirculo(circulo);
            });
            // Abro la conexión con el servidor
            miConexion.StartAsync();
            miConexion.InvokeCoreAsync("DibujarCirculo", args: new[] { circulo });

        }

        public void DibujarCirculo(clsCirculo circulo)
        {
            BoxView miCirculo = new BoxView
            {
                Color = Color.FromArgb(circulo.Colores),
                CornerRadius = 200
            };
            AbsoluteLayout.SetLayoutBounds(miCirculo, new Rect(circulo.XPosition, circulo.YPosition, 100, 100));
            Content = new AbsoluteLayout
            {
                Children = { miCirculo }
            };
        }

    }
}