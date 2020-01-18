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

import br.unipe.edu.pos.devweb.model.Usuario;
import br.unipe.edu.pos.devweb.repository.UsuarioRepository;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public List<Usuario> getUsuario() {
		
		return usuarioRepository.findAll();
		
	}
	
	@PostMapping("/usuario")
	public Usuario salvar(@Valid @RequestBody Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioById(@PathVariable Long id) {
		
		Usuario usuario = usuarioRepository.findById(id).get();
		return usuario;
		
	}
	
	@DeleteMapping("/usuario/{id}")
	public String deleteUsuarioById(@PathVariable Long id) {
		
		usuarioRepository.deleteById(id);
		return "Removido Usuario id: " + id;
		
	}
	
	@PutMapping("/usuario")
	public Usuario atualizar(@Valid @RequestBody Usuario usuario) {
		if(usuario.getId()==null)
			throw new NoSuchElementException();
		
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}
	
	@GetMapping("/usuario/nome/{username}")
	public List<Usuario> getUsuarioByUsername(@PathVariable String username) {
		
		return usuarioRepository.findUsuarioByUsername(username);
		
	}

}
