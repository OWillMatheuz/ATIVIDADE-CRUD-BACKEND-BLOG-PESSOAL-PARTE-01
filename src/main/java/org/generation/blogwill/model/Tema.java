package org.generation.blogwill.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_tema")
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)//cascade all quando for deletar, uopdate e outros a um tema especifico todos seram deletados ou upados
	@JsonIgnoreProperties("tema")
	private List<Postagens> postagens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagens> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagens> postagens) {
		this.postagens = postagens;
	}
	
	
}
