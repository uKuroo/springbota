package br.ifba.edu.blog.dtos;

import br.ifba.edu.blog.entities.Categoria;
import br.ifba.edu.blog.entities.Post;
import jakarta.validation.constraints.NotBlank;

public record PostFormDTO(
		@NotBlank(message = "O titulo não pode ser nulo")
		String titulo,
		@NotBlank(message = "O texto não pode ser nulo")
		String texto,
		@NotBlank(message = "O usuario não pode ser nulo")
		UsuarioDTO usuario, 
		@NotBlank(message = "A categoria não pode ser nulo")
		Categoria categoria
		) {

	public PostFormDTO(Post post) {
		this(post.getTitulo(), post.getTexto(), new UsuarioDTO(post.getUsuario()), post.getCategoria());
	}
}
