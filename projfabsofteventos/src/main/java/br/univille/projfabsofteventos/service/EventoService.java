package br.univille.projfabsofteventos.service;

import java.util.List;

import br.univille.projfabsofteventos.entity.Evento;

public interface EventoService {
    //salvar usuario
    Evento save(Evento usuario);

    //lista
    List<Evento> getAll();

    //buscar um cliente especifico pelo id
    Evento getById(long id);

    //delete
    Evento delete(long id);

}
