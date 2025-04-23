package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Inscricao;
import br.univille.projfabsofteventos.repository.InscricaoRepository;
import br.univille.projfabsofteventos.service.InscricaoService;

@Service
public class InscricaoServiceImpl implements InscricaoService {

    //conectar banco Autowired
    @Autowired
    private InscricaoRepository repository;

    //retorna 
    @Override
    public Inscricao save(Inscricao inscricao) {
        return repository.save(inscricao);
    }

    //retorna lista
    @Override
    public List<Inscricao> getAll() {
        return repository.findAll();
    }

    //pegar especifico
    @Override
    public Inscricao getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    //deletar
    @Override
    public Inscricao delete(long id) {
        var inscricao = getById(id);
        if(inscricao != null)
            repository.deleteById(id);
        return inscricao;
    }

}