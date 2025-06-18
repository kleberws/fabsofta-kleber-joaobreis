package br.univille.projfabsofteventos.controller;

import br.univille.projfabsofteventos.entity.Usuario;
import br.univille.projfabsofteventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service; // Corrigido para UsuarioService

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        var listaUsuarios = service.getAll();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }
        service.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        if (id <= 0 || usuario == null) {
            return ResponseEntity.badRequest().build();
        }
        var usuarioAntigo = service.getById(id);
        if (usuarioAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setSenha(usuario.getSenha());
        usuarioAntigo.setTipo(usuario.getTipo());

        service.save(usuarioAntigo);
        return new ResponseEntity<>(usuarioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable long id) {
        var usuario = service.getById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}