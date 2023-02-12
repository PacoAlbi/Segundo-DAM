import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormularioPersonasComponent } from './components/formulario-personas/formulario-personas.component';
import { FormularioPersonasReactivoComponent } from './components/formulario-personas-reactivo/formulario-personas-reactivo.component';
import { TablaPersonasComponent } from './components/tabla-personas/tabla-personas.component';
import { ListaPersonasComponent } from './components/lista-personas/lista-personas.component';

const routes: Routes = [
    {path: 'tabla', component: TablaPersonasComponent},
    {path: 'formulario', component: FormularioPersonasComponent},
    {path: 'formularioReactivo', component: FormularioPersonasReactivoComponent},
    {path: 'listado', component: ListaPersonasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
