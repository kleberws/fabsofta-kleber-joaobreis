package br.univille.projfabsofteventos.service;

import java.util.List;

import br.univille.projfabsofteventos.entity.Suporte;

public interface SuporteService {
    //salvar usuario
    Suporte save(Suporte usuario);

    //lista
    List<Suporte> getAll();

    //buscar um cliente especifico pelo id
    Suporte getById(long id);

    //delete
    Suporte delete(long id);

}
