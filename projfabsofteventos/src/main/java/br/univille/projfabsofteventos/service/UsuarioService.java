package br.univille.projfabsofteventos.service;

import java.util.List;

import br.univille.projfabsofteventos.entity.Usuario;


public interface UsuarioService {
    //salvar usuario
    Usuario save(Usuario usuario);

    //lista
    List<Usuario> getAll();

    //buscar um cliente especifico pelo id
    Usuario getById(long id);

    //delete
    Usuario delete(long id);

}
