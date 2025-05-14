package br.univille.projfabsofteventos.service;

import java.util.List;
import br.univille.projfabsofteventos.entity.CategoriaEvento;

public interface CategoriaEventoService {

    //getAll()
    List<CategoriaEvento> getAll();
    CategoriaEvento save(CategoriaEvento categoriaEvento);
    void delete(Long id);
}