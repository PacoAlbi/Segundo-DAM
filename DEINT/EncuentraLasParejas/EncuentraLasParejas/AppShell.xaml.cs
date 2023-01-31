﻿using EncuentraLasParejas.Views;

namespace EncuentraLasParejas;

public partial class AppShell : Shell
{
	public AppShell()
	{
		InitializeComponent();
        Routing.RegisterRoute("Tablero", typeof(TableroPage));
        Routing.RegisterRoute("Ranking", typeof(RankingPage));
        //Routing.RegisterRoute("Main", typeof(MainPage));       
    }
}
