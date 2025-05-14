package br.univille.projfabsofteventos.service;

import java.util.List;
import br.univille.projfabsofteventos.entity.Pagamento;

public interface PagamentoService {
    List<Pagamento> getAll();
    Pagamento save(Pagamento pagamento);
    void delete(Long id);
}