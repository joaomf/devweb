package br.unipe.edu.pos.devweb.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.edu.pos.devweb.model.TipoFesta;
import br.unipe.edu.pos.devweb.repository.TipoFestaRepository;

@RestController
@RequestMapping("/api")
public class TipoFestaController {
			
	@Autowired
	private TipoFestaRepository tipofestaRepository;

	@GetMapping("/tipofesta")
	public List<TipoFesta> getTipoFesta() {

		return tipofestaRepository.findAll();

	}

	@PostMapping("/tipofesta")
	public TipoFesta salvar(@Valid @RequestBody TipoFesta tipofesta) {
		tipofesta = tipofestaRepository.save(tipofesta);
		return tipofesta;
	}

	@GetMapping("/tipofesta/{id}")
	public TipoFesta getTipoFestaById(@PathVariable Short id) {

		TipoFesta tipofesta = tipofestaRepository.findById(id).get();
		return tipofesta;

	}

	@DeleteMapping("/tipofesta/{id}")
	public String deleteTipoFestaById(@PathVariable Short id) {

		tipofestaRepository.deleteById(id);
		return "Removido Tipo Festa id: " + id;

	}
	
	@PutMapping("/tipofesta")
	public TipoFesta atualizar(@Valid @RequestBody TipoFesta tipofesta) {
		if(tipofesta.getId()==null)
			throw new NoSuchElementException();
		
		tipofesta = tipofestaRepository.save(tipofesta);
		return tipofesta;
	}
	
	@GetMapping("/tipofesta/nome/{nome}")
	public List<TipoFesta> getTipoFestaByNome(@PathVariable String nome) {
		
		return tipofestaRepository.findTipoFestaByNome(nome);
		
	}

}
