package br.univille.projfabsofteventos.controller;

import br.univille.projfabsofteventos.entity.Inscricao;
import br.univille.projfabsofteventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService service;

    @GetMapping
    public ResponseEntity<List<Inscricao>> getInscricoes() {
        var listaInscricoes = service.getAll();
        return new ResponseEntity<>(listaInscricoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postInscricao(@RequestBody Inscricao inscricao) {
        if (inscricao == null) {
            return ResponseEntity.badRequest().body("Inscrição inválida.");
        }
        try {
            var novaInscricao = service.save(inscricao);
            return new ResponseEntity<>(novaInscricao, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> putInscricao(@PathVariable long id, @RequestBody Inscricao inscricao) {
        if (id <= 0 || inscricao == null) {
            return ResponseEntity.badRequest().build();
        }
        var inscricaoAntiga = service.getById(id);
        if (inscricaoAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        inscricaoAntiga.setDataInscricao(inscricao.getDataInscricao());
        inscricaoAntiga.setEvento(inscricao.getEvento());
        inscricaoAntiga.setUsuario(inscricao.getUsuario());

        service.save(inscricaoAntiga);
        return new ResponseEntity<>(inscricaoAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscricao(@PathVariable long id) {
        var inscricao = service.getById(id);
        if (inscricao == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
