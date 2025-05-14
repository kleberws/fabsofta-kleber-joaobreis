package br.univille.projfabsofteventos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.univille.projfabsofteventos.entity.Pagamento;
import br.univille.projfabsofteventos.service.PagamentoService;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagamento> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Pagamento save(@RequestBody Pagamento pagamento) {
        return service.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}