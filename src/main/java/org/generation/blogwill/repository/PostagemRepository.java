package org.generation.blogwill.repository;

import java.util.List;

import org.generation.blogwill.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
//extends jparepository vem da classe model onde tem a class postagens
//JpaRepository esta puxando os parametros da Classe model Postagens e qual é o tipo do ID Long
public interface PostagemRepository extends JpaRepository<Postagens, Long> {
	//buscar todos pelo titulo, que conter os caracter dentro,ele vai trazer, Igonre maiusculo ou minuscolo
	public List<Postagens> findAllByTituloContainingIgnoreCase(String titulo);
	//public List<Postagens> findAllByTextoContainingIgnoreCase (String texto);
}
