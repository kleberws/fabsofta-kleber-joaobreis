import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EventoService } from '../service/evento.service';

@Component({
  selector: 'app-form-evento',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './form-evento.html'
})
export class FormEvento implements OnInit {
  evento = {
    id: null,          // <-- agora com ID
    nome: '',
    data: '',
    local: '',
    descricao: ''
  };

  constructor(
    private eventoService: EventoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      const eventoEncontrado = this.eventoService.getById(Number(id));
      if (eventoEncontrado) {
        this.evento = { ...eventoEncontrado };
      }
    }
  }

  salvar() {
    this.eventoService.adicionar(this.evento); // o serviço já trata se é update ou novo
    this.router.navigate(['/criareventos']);
  }
}
