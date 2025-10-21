package br.ifba.edu.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifba.edu.blog.dtos.PostDTO;
import br.ifba.edu.blog.dtos.PostFormDTO;
import br.ifba.edu.blog.dtos.UsuarioDTO;
import br.ifba.edu.blog.entities.Post;
import br.ifba.edu.blog.entities.Usuario;
import br.ifba.edu.blog.repositories.PostRepository;
import br.ifba.edu.blog.repositories.UsuarioRepository;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public PostService(PostRepository postRepository, UsuarioRepository usuarioRepository) {
        this.postRepository = postRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<PostDTO> getAllPosts() {
        return this.postRepository.findAll().stream()
            .map(PostDTO::new)
            .toList();
    }

    public PostDTO createPost(PostFormDTO postForm) {
    	Optional<Usuario> usuario = this.usuarioRepository.findById(postForm.usuario().id());
    	
        Optional<UsuarioDTO> usuarioOp = Optional.ofNullable(new UsuarioDTO(usuario.get()));
        
        if (!usuarioOp.isPresent())
        	return null;
        	
        Post novoPost = new Post(null, postForm.titulo(), postForm.texto(), usuario.get(), postForm.categoria());
        novoPost = this.postRepository.save(novoPost);
        
        return new PostDTO(novoPost);
    }

    public List<PostDTO> getPostsByTitulo(String titulo) {
        List<PostDTO> posts = this.postRepository.findByTituloContaining(titulo).stream()
            .map(PostDTO::new)
            .toList();
        return posts.isEmpty() ? null : posts;
    }
    
    public List<PostDTO> getPostsByTituloContaining(String titulo) {
        List<PostDTO> posts = this.postRepository.findByTituloContaining(titulo).stream()
            .map(PostDTO::new)
            .toList();
        return posts.isEmpty() ? null : posts;
    }

    public PostDTO atualizarPost(Long id, PostFormDTO postForm) {
        Optional<Post> postOp = this.postRepository.findById(id);
        
        if (!postOp.isPresent())
        	return null;
            
    	Post post = postOp.get();
        post.setTitulo(postForm.titulo());
        post.setTexto(postForm.texto());
        post.setCategoria(postForm.categoria());
        
        Optional<Usuario> usuarioOp = this.usuarioRepository.findById(postForm.usuario().id());
        
        usuarioOp.ifPresent(post::setUsuario);
        this.postRepository.save(post);
        
        return new PostDTO(post);
    }

    public PostDTO deletePost(Long id) {
        Optional<Post> postOp = this.postRepository.findById(id);
        if (!postOp.isPresent())
        	return null;
        
        this.postRepository.deleteById(id);
        
        return new PostDTO(postOp.get());
    }
}
