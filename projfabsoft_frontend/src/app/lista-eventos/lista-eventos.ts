import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventoService } from '../service/evento.service';

@Component({
  selector: 'app-lista-eventos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-eventos.html'
})
export class ListaEventosComponent {
  eventos: any[] = [];
  descricaoAbertaId: number | null = null; // Adicionado para controlar a exibição da descrição

  constructor(private eventoService: EventoService) {
    this.eventos = this.eventoService.listar();
  }

  toggleDescricao(id: number): void {
    this.descricaoAbertaId = this.descricaoAbertaId === id ? null : id;
  }
}
