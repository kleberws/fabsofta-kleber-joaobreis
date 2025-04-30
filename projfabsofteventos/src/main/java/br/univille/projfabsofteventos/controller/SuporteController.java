package br.univille.projfabsofteventos.controller;

import br.univille.projfabsofteventos.entity.Suporte;
import br.univille.projfabsofteventos.service.SuporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suportes")
public class SuporteController {

    @Autowired
    private SuporteService service;

    @GetMapping
    public ResponseEntity<List<Suporte>> getSuportes() {
        var listaSuportes = service.getAll();
        return new ResponseEntity<>(listaSuportes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Suporte> postSuporte(@RequestBody Suporte suporte) {
        if (suporte == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(suporte);
        return new ResponseEntity<>(suporte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suporte> putSuporte(@PathVariable long id, @RequestBody Suporte suporte) {
        if (id <= 0 || suporte == null) {
            return ResponseEntity.badRequest().build();
        }
        var suporteAntigo = service.getById(id);
        if (suporteAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        suporteAntigo.setMensagem(suporte.getMensagem());
        suporteAntigo.setUsuario(suporte.getUsuario());

        service.save(suporteAntigo);
        return new ResponseEntity<>(suporteAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuporte(@PathVariable long id) {
        var suporte = service.getById(id);
        if (suporte == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}