package br.edu.ifba.pweb.gspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.pweb.gspring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
