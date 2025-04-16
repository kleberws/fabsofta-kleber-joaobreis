package br.univille.projfabsofteventos.service;

import java.util.List;

import br.univille.projfabsofteventos.entity.Inscricao;

public interface InscricaoService {
    //salvar usuario
    Inscricao save(Inscricao usuario);

    //lista
    List<Inscricao> getAll();

    //buscar um cliente especifico pelo id
    Inscricao getById(long id);

    //delete
    Inscricao delete(long id);

}
