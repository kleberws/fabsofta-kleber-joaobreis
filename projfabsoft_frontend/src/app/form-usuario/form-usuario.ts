import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-form-usuario',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usuario.html',
  styleUrl: './form-usuario.css',
  providers: [UsuarioService , Router]
})
export class FormUsuario {
 usuario: Usuario = new Usuario(0, '', '', '', '', '');

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {
    const id = this.activeRouter.snapshot.paramMap.get('id');

    if (id) {
      this.usuarioService.getUsuarioById(id)
        .subscribe(usuario => {
          this.usuario = usuario;
        });
    }
  }

  salvar(){
    this.usuarioService.saveUsuario(this.usuario)
    .subscribe( res => {
      this.router.navigate(['usuarios']);
    });
}
}
