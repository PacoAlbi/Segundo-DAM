import { Component } from '@angular/core';
import { Persona } from '../interfaces/persona';
import { PersonaserviceService } from '../services/personaservice/personaservice.service';
@Component({
  selector: 'app-tabla-personas-api',
  templateUrl: './tabla-personas-api.component.html',
  styleUrls: ['./tabla-personas-api.component.css']
})
export class TablaPersonasAPIComponent {
  listadoPersonas:Persona[];

  constructor(private personaService: PersonaserviceService) { }
  
  ngOnInit(): void {
  
  this.personaService.listadoPersonas().subscribe(data=>{
  
  this.listadoPersonas=data;
  
  }, error=>{
  
  //TODO: Controlar el error
  
  })
  
  }
}