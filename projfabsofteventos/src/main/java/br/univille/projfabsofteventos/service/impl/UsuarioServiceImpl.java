package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Usuario;
import br.univille.projfabsofteventos.repository.UsuarioRepository;
import br.univille.projfabsofteventos.service.UsuarioService;


//UsuarioService- Interface
//UsuarioServiceImpl- Classe concreta
@Service
public class UsuarioServiceImpl implements UsuarioService {

    //conectar banco Autowired
    @Autowired
    private UsuarioRepository repository;

    //retorna usuario
    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    //retorna lista
    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    //pegar especifico
    @Override
    public Usuario getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    //deletar
    @Override
    public Usuario delete(long id) {
        var cliente = getById(id);
        if(cliente != null)
            repository.deleteById(id);
        repository.deleteById(id);
    }
    
}
