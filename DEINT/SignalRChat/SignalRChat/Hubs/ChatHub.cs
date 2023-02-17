using Microsoft.AspNetCore.SignalR;

namespace SignalRChat.Hubs
{
    public class ChatHub : Hub
    {
        public async Task SendMessage(string user, string hueco)
        {
            await Clients.All.SendAsync("ReceiveMessage", hueco);
            await Clients.User(user).SendAsync("ReceiveMessage", hueco);
        }
    }
}