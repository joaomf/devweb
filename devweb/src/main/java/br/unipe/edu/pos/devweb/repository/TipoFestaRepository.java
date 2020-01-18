package br.unipe.edu.pos.devweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.edu.pos.devweb.model.TipoFesta;

@Repository
public interface TipoFestaRepository extends JpaRepository<TipoFesta, Short>{
	
	public List<TipoFesta> findTipoFestaByNome(String nome);

}
