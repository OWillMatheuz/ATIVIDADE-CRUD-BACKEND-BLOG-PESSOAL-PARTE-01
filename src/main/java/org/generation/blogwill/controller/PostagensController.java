package org.generation.blogwill.controller;

import java.util.List;

import org.generation.blogwill.model.Postagens;
import org.generation.blogwill.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //pacote de controller
@RequestMapping("/postagens") //definir qual é a rota ou url
@CrossOrigin("*")// vai aceitar postagens de qualquer origin
public class PostagensController {
	
	@Autowired //serviço de injeção do spring
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	
	
}
