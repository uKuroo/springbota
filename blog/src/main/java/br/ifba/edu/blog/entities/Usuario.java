package br.ifba.edu.blog.entities;

import br.ifba.edu.blog.dtos.UsuarioFormDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(UsuarioFormDTO usuarioForm) {
		super();
		this.nome = usuarioForm.nome();
		this.login = usuarioForm.login();
		this.senha = usuarioForm.senha();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	

}
