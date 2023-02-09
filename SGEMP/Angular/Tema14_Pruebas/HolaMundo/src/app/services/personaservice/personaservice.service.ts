import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from 'src/app/interfaces/persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaserviceService {
/*URL de mi aPI para usar en todo el Servicio*/

urlWebAPI='https://apipersonaspaco.azurewebsites.net/api/personascondepartamento';

constructor(private http: HttpClient) { }

listadoPersonas(): Observable<Persona[]>{

return this.http.get<Persona[]>(this.urlWebAPI);

}
}
