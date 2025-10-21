package br.ifba.edu.blog.dtos;

import br.ifba.edu.blog.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioFormDTO(
		@NotBlank(message = "O nome não pode ser nulo")
		String nome,
		@NotBlank(message = "O login não pode ser nulo")
		String login, 
		@NotBlank(message = "A senha não pode ser nulo")
		String senha) {
	
	public UsuarioFormDTO(Usuario usuario) {
		this(usuario.getNome(), usuario.getLogin(), usuario.getSenha());
	}

}
