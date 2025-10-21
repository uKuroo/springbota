package br.ifba.edu.blog.dtos;

import br.ifba.edu.blog.entities.Usuario;

public record UsuarioDTO(Long id, String nome, String login) {
	
	public UsuarioDTO(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getLogin());
	}

}
