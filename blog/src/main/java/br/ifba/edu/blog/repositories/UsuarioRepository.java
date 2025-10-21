package br.ifba.edu.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.blog.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByNomeContaining(String nome);
	
	

}
