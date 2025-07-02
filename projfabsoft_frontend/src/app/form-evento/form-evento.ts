import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { EventoService } from '../service/evento.service';

@Component({
  selector: 'app-form-evento',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-evento.html'
})
export class FormEvento {
  evento = {
    nome: '',
    data: '',
    local: ''
  };

  constructor(private eventoService: EventoService, private router: Router) {}

  salvar() {
    this.eventoService.adicionar(this.evento);
    this.router.navigate(['/criareventos']);
  }
}
