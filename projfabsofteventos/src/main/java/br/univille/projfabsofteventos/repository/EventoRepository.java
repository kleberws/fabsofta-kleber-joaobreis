package br.univille.projfabsofteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsofteventos.entity.Evento;

@Repository
public interface EventoRepository 
        extends JpaRepository<Evento, Long>{

    
}
