package br.ifba.edu.blog.dtos;

import br.ifba.edu.blog.entities.Categoria;
import br.ifba.edu.blog.entities.Post;

public record PostDTO(Long id, String titulo, String Texto, UsuarioDTO usuario, Categoria categoria) {

	public PostDTO(Post post) {
		this(post.getId(), post.getTitulo(), post.getTexto(), new UsuarioDTO(post.getUsuario()), post.getCategoria());
	}

}
