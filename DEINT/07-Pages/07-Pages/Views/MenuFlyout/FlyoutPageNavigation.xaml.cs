namespace _07_Pages.Views.MenuFlyout;

public partial class FlyoutPageNavigation : FlyoutPage
{
	public FlyoutPageNavigation()
	{
		InitializeComponent();
        //flyoutPage.collectionView.SelectionChanged += OnSelectionChange;

	}
    /*
	public void OnSelectionChange(object sender, SelectionChangedEventArgs e)
	{
        var item = e.CurrentSelection.FirstOrDefault() as FlyoutPageItem; 

        if (item != null)
        {
            Detail = new NavigationPage((Page)Activator.CreateInstance(item.TargetType));
            //IsPresented = false;
        }
    }*/
}