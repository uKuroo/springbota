package br.edu.ifba.pweb.gspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.pweb.gspring.entities.User;
import br.edu.ifba.pweb.gspring.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.getById(id);
	}
	
	@PostMapping
	public User postUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@PutMapping
	public User putUser(Long id, @RequestBody User newUser) {
		User user = userRepository.getById(id);
		if(user == null)
			return null;
		
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		
		return userRepository.save(user);
	}
	
	@DeleteMapping
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
