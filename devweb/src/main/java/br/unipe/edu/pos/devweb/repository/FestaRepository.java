package br.unipe.edu.pos.devweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unipe.edu.pos.devweb.model.Festa;

@Repository
public interface FestaRepository extends JpaRepository<Festa, Long>{

	public List<Festa> findFestaByNome(String nome);
	
	public List<Festa> findFestaByNomeLike(String nome);
	
	public List<Festa> findFestaByValorBetween(Float valorA, Float valorB);
	
	public List<Festa> findFestaByTema(String tema);
	
	public List<Festa> findFestaByNomeAndTema(String nome, String tema);
	
	//@Query
	//public List<Festa> buscaValorSuperiorIgual(Float valor);
	
	@Query("select f from Festa f where f.nome = :nome")
	public List<Festa> buscaPorNome(@Param("nome") String nome);
	
}

