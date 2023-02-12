import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TablaPersonasComponent } from './components/tabla-personas/tabla-personas.component';
import { FormularioPersonasComponent } from './components/formulario-personas/formulario-personas.component';
import { ListaPersonasComponent } from './components/lista-personas/lista-personas.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormularioPersonasReactivoComponent } from './components/formulario-personas-reactivo/formulario-personas-reactivo.component';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { HttpClientModule } from '@angular/common/http';
import { TablaApiPersonasDepComponent } from './components/tabla-api-personas-dep/tabla-api-personas-dep.component';

@NgModule({
  declarations: [
    AppComponent,
    TablaPersonasComponent,
    FormularioPersonasComponent,
    ListaPersonasComponent,
    FormularioPersonasReactivoComponent,
    TablaApiPersonasDepComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatProgressSpinnerModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
