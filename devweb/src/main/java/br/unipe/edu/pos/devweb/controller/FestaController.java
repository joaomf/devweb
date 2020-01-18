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

import br.unipe.edu.pos.devweb.model.Festa;
import br.unipe.edu.pos.devweb.repository.FestaRepository;


@RestController
@RequestMapping("/api")
public class FestaController {
	
	@Autowired
	private FestaRepository festaRepository;
	
	@GetMapping("/festa")
	public List<Festa> getFesta() {
		
		return festaRepository.findAll();
		
	}
	
	@PostMapping("/festa")
	public Festa salvar(@Valid @RequestBody Festa festa) {
		festa = festaRepository.save(festa);
		return festa;
	}

	@GetMapping("/festa/{id}")
	public Festa getFestaById(@PathVariable Long id) {
		
		Festa festa = festaRepository.findById(id).get();
		return festa;
		
	}
	
	@DeleteMapping("/festa/{id}")
	public String deleteFestaById(@PathVariable Long id) {
		
		festaRepository.deleteById(id);
		return "Removida Festa id: " + id;
		
	}
	
	@PutMapping("/festa")
	public Festa atualizar(@Valid @RequestBody Festa festa) {
		if(festa.getId()==null)
			throw new NoSuchElementException();
		
		festa = festaRepository.save(festa);
		return festa;
	}
	
	@GetMapping("/festa/nome/{nome}")
	public List<Festa> getFestaByNome(@PathVariable String nome) {
		
		return festaRepository.findFestaByNome(nome);
		
	}
	
	@GetMapping("/festa/valor/between/{valorA}/{valorB}")
	public List<Festa> getFestaByValorBetween(@PathVariable Float valorA, @PathVariable Float valorB) {
		
		return festaRepository.findFestaByValorBetween(valorA, valorB);
		
	}
	
}
