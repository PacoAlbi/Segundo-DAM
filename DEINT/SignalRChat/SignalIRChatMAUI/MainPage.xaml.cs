using Microsoft.AspNetCore.SignalR.Client;

namespace SignalIRChatMAUI
{
    public partial class MainPage : ContentPage
    {
        private readonly HubConnection hubConnection;
        public MainPage()
        {
            InitializeComponent();

            var UrlBase = "http://localhost";
            //Android no se podrá conectar a esta url

            if (DeviceInfo.Current.Platform == DevicePlatform.Android)
            {
                UrlBase = "http://10.0.2.2";
            }
            hubConnection = new HubConnectionBuilder().WithUrl($"{UrlBase}:5086/ChatHub").Build();

            hubConnection.On<string, string>("ReceiveMessage", (user, message) =>
            {
                lblChat.Text += $"<b>{user}</b>: {message}<br/>";
            });
            //Iniciamos el hub en el hilo principalpara no bloquear la interfaz
            Task.Run(() =>
            {
                Dispatcher.Dispatch(async () =>
                {
                    await hubConnection.StartAsync();
                });
            });
        }

        private async void btnEnviar_Clicked(object sender, EventArgs e)
        {
            await hubConnection.InvokeCoreAsync("SendMessage", args: new[]
            {
                txtUserName.Text,
                txtMensaje.Text,
            });

            txtMensaje.Text = String.Empty;
        }
    }
}