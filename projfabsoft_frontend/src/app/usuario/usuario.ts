import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuario',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.html',
  styleUrls: ['./usuario.css'],
  providers: [UsuarioService, Router]

})
export class UsuarioComponent {
  public listaUsuarios: Usuario[] = [];

  constructor(
    private usuarioService:UsuarioService,
    private router:Router
  ){}

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(resposta => {
      this.listaUsuarios = resposta;
    })
}
novo(){
  this.router.navigate(['usuarios/novo']);
}
}

export { Usuario };
