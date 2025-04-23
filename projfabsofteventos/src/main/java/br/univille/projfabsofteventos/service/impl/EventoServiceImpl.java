package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Evento;
import br.univille.projfabsofteventos.repository.EventoRepository;
import br.univille.projfabsofteventos.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

    //conectar banco Autowired
    @Autowired
    private EventoRepository repository;

    //retorna 
    @Override
    public Evento save(Evento evento) {
        return repository.save(evento);
    }

    //retorna lista
    @Override
    public List<Evento> getAll() {
        return repository.findAll();
    }

    //pegar especifico
    @Override
    public Evento getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    //deletar
    @Override
    public Evento delete(long id) {
        var evento = getById(id);
        if(evento != null)
            repository.deleteById(id);
        return evento;
    }

}