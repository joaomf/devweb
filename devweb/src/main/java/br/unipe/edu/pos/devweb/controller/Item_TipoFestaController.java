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

import br.unipe.edu.pos.devweb.model.Item_TipoFesta;
import br.unipe.edu.pos.devweb.repository.Item_TipoFestaRepository;

@RestController
@RequestMapping("/api")
public class Item_TipoFestaController {
	
	@Autowired
	private Item_TipoFestaRepository item_tipofestaRepository;
	
	@GetMapping("/itemtipofesta")
	public List<Item_TipoFesta> getItem_TipoFesta() {
		
		return item_tipofestaRepository.findAll();
		
	}
	
	@PostMapping("/itemtipofesta")
	public Item_TipoFesta salvar(@Valid @RequestBody Item_TipoFesta item_tipofesta) {
		item_tipofesta = item_tipofestaRepository.save(item_tipofesta);
		return item_tipofesta;
	}
	
	@GetMapping("/itemtipofesta/{id}")
	public Item_TipoFesta getClienteById(@PathVariable Long id) {
		
		Item_TipoFesta item_tipofesta = item_tipofestaRepository.findById(id).get();
		return item_tipofesta;
		
	}
	
	@DeleteMapping("/itemtipofesta/{id}")
	public String deleteClienteById(@PathVariable Long id) {
		
		item_tipofestaRepository.deleteById(id);
		return "Removido Item_TipoFesta id: " + id;
		
	}
	
	@PutMapping("/itemtipofesta")
	public Item_TipoFesta atualizar(@Valid @RequestBody Item_TipoFesta item_tipofesta) {
		if(item_tipofesta.getId()==null)
			throw new NoSuchElementException();
		
		item_tipofesta = item_tipofestaRepository.save(item_tipofesta);
		return item_tipofesta;
	}
	
	@GetMapping("/itemtipofesta/descricao/{descricao}")
	public List<Item_TipoFesta> getClienteByDescricao(@PathVariable String descricao) {
		
		return item_tipofestaRepository.findItem_TipoFestaByDescricao(descricao);
		
	}


}
