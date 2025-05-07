package br.univille.projfabsofteventos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsofteventos.entity.Inscricao;
import br.univille.projfabsofteventos.repository.EventoRepository;
import br.univille.projfabsofteventos.repository.UsuarioRepository;
import br.univille.projfabsofteventos.repository.InscricaoRepository;
import br.univille.projfabsofteventos.service.InscricaoService;

@Service
public class InscricaoServiceImpl implements InscricaoService {

    @Autowired
    private InscricaoRepository repository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Inscricao save(Inscricao inscricao) {
        if (inscricao.getEvento() == null || !eventoRepository.existsById(inscricao.getEvento().getId())) {
            throw new IllegalArgumentException("Evento não encontrado.");
        }
        if (inscricao.getUsuario() == null || !usuarioRepository.existsById(inscricao.getUsuario().getId())) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        return repository.save(inscricao);
    }

    @Override
    public List<Inscricao> getAll() {
        return repository.findAll();
    }

    @Override
    public Inscricao getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Inscricao delete(long id) {
        var inscricao = getById(id);
        if (inscricao != null)
            repository.deleteById(id);
        return inscricao;
    }
}
