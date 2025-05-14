package br.univille.projfabsofteventos.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.projfabsofteventos.entity.Pagamento;
import br.univille.projfabsofteventos.exception.NotFoundException;
import br.univille.projfabsofteventos.repository.PagamentoRepository;
import br.univille.projfabsofteventos.repository.InscricaoRepository;
import br.univille.projfabsofteventos.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository repository;
    private final InscricaoRepository inscricaoRepository;

    public PagamentoServiceImpl(PagamentoRepository repository, InscricaoRepository inscricaoRepository) {
        this.repository = repository;
        this.inscricaoRepository = inscricaoRepository;
    }

    @Override
    public List<Pagamento> getAll() {
        return repository.findAll();
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        if (!inscricaoRepository.existsById(pagamento.getInscricao().getId())) {
            throw new NotFoundException("A inscrição com ID " + pagamento.getInscricao().getId() + " não foi encontrada.");
        }
        return repository.save(pagamento);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}