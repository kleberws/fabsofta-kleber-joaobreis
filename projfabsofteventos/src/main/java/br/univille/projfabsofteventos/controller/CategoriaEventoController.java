package br.univille.projfabsofteventos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.univille.projfabsofteventos.entity.CategoriaEvento;
import br.univille.projfabsofteventos.service.CategoriaEventoService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaEventoController {

    private final CategoriaEventoService service;

    public CategoriaEventoController(CategoriaEventoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaEvento> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CategoriaEvento save(@RequestBody CategoriaEvento categoriaEvento) {
        return service.save(categoriaEvento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}