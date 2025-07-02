import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventoService {
  private eventos: any[] = [];
  private proximoId = 1;

  constructor() {
    this.carregarDoLocalStorage();
  }

  listar() {
    return this.eventos;
  }

  adicionar(evento: any) {
    evento.id = this.proximoId++;
    this.eventos.push({ ...evento });
    this.salvarNoLocalStorage();
  }

excluir(id: number): void {
  this.eventos = this.eventos.filter(evento => evento.id !== id);
  this.salvarNoLocalStorage();
}



  buscarPorId(id: number) {
    return this.eventos.find(e => e.id === id);
  }

  atualizar(id: number, dadosAtualizados: any) {
    const index = this.eventos.findIndex(e => e.id === id);
    if (index !== -1) {
      this.eventos[index] = { id, ...dadosAtualizados };
      this.salvarNoLocalStorage();
    }
  }

  private salvarNoLocalStorage() {
    localStorage.setItem('eventos', JSON.stringify(this.eventos));
    localStorage.setItem('contadorId', this.proximoId.toString());
  }

  private carregarDoLocalStorage() {
    const eventosSalvos = localStorage.getItem('eventos');
    const contadorSalvo = localStorage.getItem('contadorId');
    if (eventosSalvos) {
      this.eventos = JSON.parse(eventosSalvos);
    }
    if (contadorSalvo) {
      this.proximoId = +contadorSalvo;
    }
  }
}
