import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario';
import { FormUsuario } from './form-usuario/form-usuario';
import { CriarEventosComponent } from './criar-eventos/criar-eventos';
import { ListaEventosComponent } from './lista-eventos/lista-eventos';
import { FormEvento } from './form-evento/form-evento';

export const routes: Routes = [
  { path: 'usuarios', component: UsuarioComponent },
  { path: 'usuarios/novo', component: FormUsuario },
  { path: 'criareventos', component: CriarEventosComponent },
  { path: 'criareventos/novoevento', component: FormEvento },
  { path: 'listadeeventos', component: ListaEventosComponent },
  { path: '', redirectTo: '/usuarios', pathMatch: 'full' }
];
