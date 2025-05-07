package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Suporte;
import br.univille.projfabsofteventos.repository.SuporteRepository;
import br.univille.projfabsofteventos.repository.UsuarioRepository;
import br.univille.projfabsofteventos.service.SuporteService;

@Service
public class SuporteServiceImpl implements SuporteService {

    @Autowired
    private SuporteRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Suporte save(Suporte suporte) {
        if (suporte.getUsuario() == null || suporte.getUsuario().getId() <= 0) {
            throw new IllegalArgumentException("Usuário inválido.");
        }

        // Verifica se o usuário existe no banco
        boolean usuarioExiste = usuarioRepository.existsById(suporte.getUsuario().getId());
        if (!usuarioExiste) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        return repository.save(suporte);
    }

    @Override
    public List<Suporte> getAll() {
        return repository.findAll();
    }

    @Override
    public Suporte getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Suporte delete(long id) {
        var suporte = getById(id);
        if (suporte != null)
            repository.deleteById(id);
        return suporte;
    }
}