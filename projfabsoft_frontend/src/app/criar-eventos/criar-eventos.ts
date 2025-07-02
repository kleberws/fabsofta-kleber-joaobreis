import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { EventoService } from '../service/evento.service';

declare var bootstrap: any;

@Component({
  selector: 'app-criar-eventos',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './criar-eventos.html'
})
export class CriarEventosComponent {
  eventos: any[] = [];
  eventoSelecionado: any = null;

  evento: any = {
    nome: '',
    data: '',
    local: '',
    descricao: ''
  };

  constructor(
    private router: Router,
    private eventoService: EventoService
  ) {
    this.eventos = this.eventoService.listar();
  }

  abrirModalExcluir(evento: any) {
    this.eventoSelecionado = evento;
  }

  confirmarExclusao() {
    if (this.eventoSelecionado) {
      this.eventoService.excluir(this.eventoSelecionado.id);
      this.eventos = this.eventoService.listar();

      const modalElement = document.getElementById('modalExcluir');
      if (modalElement) {
        const modalInstance =
          bootstrap.Modal.getInstance(modalElement) ||
          new bootstrap.Modal(modalElement);
        modalInstance.hide();
      }

      document.querySelectorAll('.modal-backdrop').forEach((el) => el.remove());
    }
  }

  alterarEvento(evento: any) {
    this.router.navigate(['/criareventos/alterar', evento.id]);
  }
}
