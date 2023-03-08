package org.generation.blogwill.model;
// todas anotações são parametros que vai em cima das classes que definem certo comportamento para elas
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // essa anotação vai ser uma classe do jpa
@Table(name="tb_postagens")//vai criar uma tabela postagens, anotação que é uma entidade
public class Postagens {
	@Id //criar id no db
	@GeneratedValue(strategy = GenerationType.IDENTITY)//vai se transformar em uma primary key
	private Long id;
	
	@NotBlank(message = "O atributo titulo é obrigatorio!")
	@Size(min =5, max= 100)//anotação de quantidade de caracter que o usuario consegue enviar
	private String titulo;
	
	@NotBlank(message = "O atributo texto é obrigatorio!")
	@Size(min = 10, max = 800)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	//Assim que passar algum dado por essa classe vai capturar extamente a data e a hora.
	private Date data = new java.sql.Date(System.currentTimeMillis()); //quando passar dado por essa classe vai capturar
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private UsuarioModel usuario;
	
	

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
