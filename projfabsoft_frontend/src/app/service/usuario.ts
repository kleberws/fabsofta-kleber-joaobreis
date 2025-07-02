import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiURL = 'http://localhost:8080/api/v1/usuarios';

  constructor(private http: HttpClient) {}

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiURL);
  }
  saveUsuario(usuario: Usuario) {
    if(usuario.id){
    return this.http.put(this.apiURL + '/' + usuario.id, usuario);
    }
    return this.http.post(this.apiURL,usuario);
  }
  getUsuarioById(id: any) {
    return this.http.get<Usuario>(this.apiURL + '/' + id);
  }
  excluirUsuario(id: any){
    return this.http.delete<Usuario>(this.apiURL +  '/' + id);
  }
}