package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Suporte;
import br.univille.projfabsofteventos.repository.SuporteRepository;
import br.univille.projfabsofteventos.service.SuporteService;



@Service
public class SuporteServiceImpl implements SuporteService {

    //conectar banco Autowired
    @Autowired
    private SuporteRepository repository;

    //retorna 
    @Override
    public Suporte save(Suporte suporte) {
        return repository.save(suporte);
    }

    //retorna lista
    @Override
    public List<Suporte> getAll() {
        return repository.findAll();
    }

    //pegar especifico
    @Override
    public Suporte getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    //deletar
    @Override
    public Suporte delete(long id) {
        var suporte = getById(id);
        if(suporte != null)
            repository.deleteById(id);
        return suporte;
    }

}