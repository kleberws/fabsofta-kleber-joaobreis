package br.univille.projfabsofteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projfabsofteventos.entity.CategoriaEvento;

public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {
}