package org.generation.blogwill.repository;

import java.util.List;

import org.generation.blogwill.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
		
}
