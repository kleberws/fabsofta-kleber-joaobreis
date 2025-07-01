import { Component } from '@angular/core';
import { Usuario } from '..model/usuario';
import{ UsuarioService } from '../service/usuario'
@Component({
  selector: 'app-usuario',
  imports: [],
  templateUrl: './usuario.html',
  styleUrls: ['./usuario.css']
})
export class Usuario {

  public listaUsuarios:Usuario[] = [];
  constructor(
    private usuarioService:UsuarioService
  ){}

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(resposta => {
      this.listaUsuarios = resposta
    })

  }
}