package br.unipe.edu.pos.devweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoFesta {
	
	@Id
	@GeneratedValue
	private Short id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=255)
	private String descricao;
	
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
