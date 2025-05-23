package br.univille.projfabsofteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsofteventos.entity.Usuario;

@Repository
public interface UsuarioRepository 
        extends JpaRepository<Usuario, Long>{

    
}
