namespace SignalIRChatMAUI
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();

            var UrlBase = "http://localhost";
            //Android no se podrá conectar a esta url

            if (DeviceInfo.Current.Platform == DevicePlatform.Android)
            {
                UrlBase = "http://10.0.2.2";
            }
        }

        private void btnEnviar_Clicked(object sender, EventArgs e)
        {

        }
    }
}