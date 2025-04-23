package br.univille.projfabsofteventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsofteventos.entity.Usuario;
import br.univille.projfabsofteventos.service.UsuarioService;
import io.micrometer.core.ipc.http.HttpSender.Response;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        var listaUsuarios = service.getAll();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario>
        postUsuario(@RequestBody Usuario usuario){
    if(usuario == null){
        return ResponseEntity.badRequest().build();
    }
    if(usuario.getId() == 0){
        service.save(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    return ResponseEntity.badRequest().build();
}
// put: link/{id}. API REST
    @PutMapping("/{id}")
    public ResponseEntity<Usuario>
        putUsuario(@PathVariable long id,
                    @RequestBody Usuario usuario){
        if(id <= 0 || usuario == null){
            return ResponseEntity.badRequest().build();
        }
        var usuarioAntigo = service.getById(id);
        if(usuarioAntigo == null){
            return ResponseEntity.notFound().build();
        }

        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setSenha(usuario.getEmail());
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setTipo(usuario.getTipo());

        //fazr set de senha e email.
    }
}