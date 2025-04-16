package br.univille.projfabsofteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsofteventos.entity.Inscricao;

@Repository
public interface InscricaoRepository 
        extends JpaRepository<Inscricao, Long>{

    
}
