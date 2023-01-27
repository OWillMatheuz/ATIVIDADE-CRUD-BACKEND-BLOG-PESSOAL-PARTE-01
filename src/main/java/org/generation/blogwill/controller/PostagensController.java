package org.generation.blogwill.controller;

import java.util.List;

import org.generation.blogwill.model.Postagens;
import org.generation.blogwill.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //pacote de controller
@RequestMapping("/postagens") //definir qual é a rota ou url, endpoint de postagem
@CrossOrigin("*")// vai aceitar postagens de qualquer origin Angular, react e outros
public class PostagensController {
	
	@Autowired //serviço de injeção do spring
	//nao podemos instanciar uma interface entao deixamos o spring fazer isto
	private PostagemRepository repository;
	
	//expor pra api que este metodo é Get.
	//Sempre que vir requisição externa pela uri postagens for um metodo get vai dispara esse metodo
	@GetMapping
	public ResponseEntity<List<Postagens>> GetAll(){ //getall bsucar todas as perguntas 
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagens> post(@RequestBody @Valid Postagens postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	@PutMapping
	public ResponseEntity<Postagens> put(@RequestBody @Valid Postagens postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
	

