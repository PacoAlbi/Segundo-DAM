import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../interfaces/persona';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {
  /*URL de mi aPI para usar en todo el Servicio*/
  urlWebAPI='https://apipersonaspaco.azurewebsites.net/api/personascondepartamento';

  constructor(private http: HttpClient) { }
  
  listadoPersonas(): Observable<Persona[]>{
  return this.http.get<Persona[]>(this.urlWebAPI);
  }

  eliminarPersona(id:number): void {
    this.http.delete<number>(this.urlWebAPI+"/"+id);
 }
}