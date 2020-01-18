package br.unipe.edu.pos.devweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import javax.validation.constraints.NotEmpty;

@Entity //Nome da classe = nome da tabela
//@Table(name="tb_festa") -> muda o nome da tabela
public class Festa {
	
	@Id
	@GeneratedValue
	private Long id;
//	@NotEmpty -> Validacao
	private String nome;
	private String tema;
	private Float valor;
	
	@ManyToOne
	private TipoFesta tipofesta;
	
	@JsonIgnoreProperties({"listaFesta"})
	@ManyToOne
	private Usuario usuario;
		
	public TipoFesta getTipofesta() {
		return tipofesta;
	}

	public void setTipofesta(TipoFesta tipofesta) {
		this.tipofesta = tipofesta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	

}
