﻿using DAL;

namespace _08_Ejercicio5
{
	public partial class MainPage : ContentPage
	{
        
        public MainPage()
		{
			InitializeComponent();

            lista.ItemsSource = ListadoCompletoPersonas.obtenerListadoPersonas();
        }
    }
}