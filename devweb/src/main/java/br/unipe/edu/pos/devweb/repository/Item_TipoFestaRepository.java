package br.unipe.edu.pos.devweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.edu.pos.devweb.model.Item_TipoFesta;

@Repository
public interface Item_TipoFestaRepository extends JpaRepository<Item_TipoFesta, Long>{
	
	public List<Item_TipoFesta> findItem_TipoFestaByDescricao(String descricao);

}
