package br.univille.projfabsofteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsofteventos.entity.Suporte;

@Repository
public interface SuporteRepository 
        extends JpaRepository<Suporte, Long>{

    
}
