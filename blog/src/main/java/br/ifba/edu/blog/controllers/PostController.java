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

import br.ifba.edu.blog.dtos.PostDTO;
import br.ifba.edu.blog.dtos.PostFormDTO;
import br.ifba.edu.blog.services.PostService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostDTO> getAllPosts() {
		return this.postService.getAllPosts();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PostDTO> createPost(@RequestBody @Valid PostFormDTO post) {
		return ResponseEntity.status(201).body(this.postService.createPost(post));
	}
	
	@GetMapping("/buscarPorTitulo")
	public ResponseEntity<List<PostDTO>> getPostsByTitulo(String titulo) {
		 List<PostDTO> posts = this.postService.getPostsByTitulo(titulo);
		if (posts != null) {
			return ResponseEntity.ok(posts);
		} else {
			return ResponseEntity.noContent().build();
		}	 	
	}
	
	@GetMapping("/buscarPorTituloContendo")
	public ResponseEntity<List<PostDTO>> getPostsByTituloContaining(String titulo) {
		 List<PostDTO> posts = this.postService.getPostsByTituloContaining(titulo);
		if (posts != null) {
			return ResponseEntity.ok(posts);
		} else {
			return ResponseEntity.noContent().build();
		}	 	
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PostDTO> atualizarPost(@PathVariable Long id, @RequestBody PostFormDTO post) {
		PostDTO postAtualizado = this.postService.atualizarPost(id, post);
		if (postAtualizado != null) {
			return ResponseEntity.ok(postAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PostDTO> deletePost(@PathVariable Long id) {
		PostDTO postDeletado = this.postService.deletePost(id);
		if (postDeletado != null) {
			return ResponseEntity.ok(postDeletado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
