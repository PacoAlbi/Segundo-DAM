using Entidades;
using Microsoft.AspNetCore.SignalR;

namespace EjericioCirculos.Hubs
{
    public class HubCirculos : Hub
    {
        public async Task SendMessage(clsCirculo circulo)
        {
            await Clients.Others.SendAsync("DibujarCirculo", circulo);
        }

    }
}
