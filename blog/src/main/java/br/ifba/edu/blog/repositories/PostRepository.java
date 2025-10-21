package br.ifba.edu.blog.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	Collection<Post> findByTituloContaining(String titulo);

}
