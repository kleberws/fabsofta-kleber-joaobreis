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

  constructor(private eventoService: EventoService) {
    this.eventos = this.eventoService.listar();
  }
}
