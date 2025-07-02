package br.univille.projfabsofteventos.controller;

import br.univille.projfabsofteventos.entity.Suporte;
import br.univille.projfabsofteventos.entity.Usuario;
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

    @GetMapping("/{id}")
    public ResponseEntity<Suporte> getSuporteId(@PathVariable Long id){
        var suporte = service.getById(id);

        return new ResponseEntity<Suporte>(suporte, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postSuporte(@RequestBody Suporte suporte) {
        try {
            var novoSuporte = service.save(suporte);
            return new ResponseEntity<>(novoSuporte, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putSuporte(@PathVariable long id, @RequestBody Suporte suporte) {
        if (id <= 0 || suporte == null) {
            return ResponseEntity.badRequest().body("ID ou suporte inválido.");
        }

        var suporteAntigo = service.getById(id);
        if (suporteAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        suporteAntigo.setMensagem(suporte.getMensagem());
        suporteAntigo.setUsuario(suporte.getUsuario());

        try {
            var suporteAtualizado = service.save(suporteAntigo);
            return new ResponseEntity<>(suporteAtualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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