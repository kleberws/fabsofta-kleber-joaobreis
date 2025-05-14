package br.univille.projfabsofteventos.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import br.univille.projfabsofteventos.entity.CategoriaEvento;
import br.univille.projfabsofteventos.repository.CategoriaEventoRepository;
import br.univille.projfabsofteventos.service.CategoriaEventoService;

@Service
public class CategoriaEventoServiceImpl implements CategoriaEventoService {

    private final CategoriaEventoRepository repository;
    
    public CategoriaEventoServiceImpl(CategoriaEventoRepository repository) {
        this.repository = repository;
    }
    //get
    @Override
    public List<CategoriaEvento> getAll() {
        return repository.findAll();
    }
    //get by id
    @Override
    public CategoriaEvento save(CategoriaEvento categoriaEvento) {
        return repository.save(categoriaEvento);
    }

    //delete
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}