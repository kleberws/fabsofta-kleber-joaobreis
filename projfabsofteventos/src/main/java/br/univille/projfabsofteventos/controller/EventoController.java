package br.univille.projfabsofteventos.controller;

import br.univille.projfabsofteventos.entity.Evento;
import br.univille.projfabsofteventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public ResponseEntity<List<Evento>> getEventos() {
        var listaEventos = service.getAll();
        return new ResponseEntity<>(listaEventos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evento> postEvento(@RequestBody Evento evento) {
        if (evento == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> putEvento(@PathVariable long id, @RequestBody Evento evento) {
        if (id <= 0 || evento == null) {
            return ResponseEntity.badRequest().build();
        }
        var eventoAntigo = service.getById(id);
        if (eventoAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        eventoAntigo.setNome(evento.getNome());
        eventoAntigo.setDescricao(evento.getDescricao());
        eventoAntigo.setData(evento.getData());
        eventoAntigo.setLocal(evento.getLocal());
        eventoAntigo.setOrganizador(evento.getOrganizador());

        service.save(eventoAntigo);
        return new ResponseEntity<>(eventoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable long id) {
        var evento = service.getById(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}