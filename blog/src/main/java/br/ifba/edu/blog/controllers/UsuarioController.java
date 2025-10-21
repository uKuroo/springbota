package br.ifba.edu.blog.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.blog.dtos.UsuarioDTO;
import br.ifba.edu.blog.dtos.UsuarioFormDTO;
import br.ifba.edu.blog.services.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public List<UsuarioDTO> getAllUsuarios() {
		return this.usuarioService.getAllUsuarios();
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody @Valid UsuarioFormDTO usuario) {
		return ResponseEntity.status(201).body(this.usuarioService.createUsuario(usuario));
	}
	
	
	@GetMapping("/buscarPorNome")
	public ResponseEntity<List<UsuarioDTO>> getUsuarioByNome(String nome) {
		 List<UsuarioDTO> usuarios = this.usuarioService.getUsuarioByNome(nome);
		if (usuarios != null) {
			return ResponseEntity.ok(usuarios);
		} else {
			return ResponseEntity.noContent().build();
		}	 	
	}
	 
	
	 
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioFormDTO usuario) {
		UsuarioDTO usuarioAtualizado = this.usuarioService.atualizarUsuario(id, usuario);
		if (usuarioAtualizado != null) {
			return ResponseEntity.ok(usuarioAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDTO> deleteUsuario(@PathVariable Long id) {
		UsuarioDTO usuarioDeletado = this.usuarioService.deleteUsuario(id);
		if (usuarioDeletado != null) {
			return ResponseEntity.ok(usuarioDeletado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
