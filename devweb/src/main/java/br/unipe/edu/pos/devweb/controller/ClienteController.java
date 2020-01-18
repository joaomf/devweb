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

import br.unipe.edu.pos.devweb.model.Cliente;
import br.unipe.edu.pos.devweb.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	public List<Cliente> getCliente() {
		
		return clienteRepository.findAll();
		
	}
	
	@PostMapping("/cliente")
	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		
		Cliente cliente = clienteRepository.findById(id).get();
		return cliente;
		
	}
	
	@DeleteMapping("/cliente/{id}")
	public String deleteClienteById(@PathVariable Long id) {
		
		clienteRepository.deleteById(id);
		return "Removido Cliente id: " + id;
		
	}
	
	@PutMapping("/cliente")
	public Cliente atualizar(@Valid @RequestBody Cliente cliente) {
		if(cliente.getId()==null)
			throw new NoSuchElementException();
		
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	@GetMapping("/cliente/nome/{nome}")
	public List<Cliente> getClienteByNome(@PathVariable String nome) {
		
		return clienteRepository.findClienteByNome(nome);
		
	}


}
