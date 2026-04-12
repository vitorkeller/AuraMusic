package com.auramusic.backend.services;

import org.springframework.stereotype.Service;

import com.auramusic.backend.entities.User;
import com.auramusic.backend.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	// CREATE
	public User create(User user) {
		return repository.save(user);
	}

	// READ ALL
	public List<User> findAll() {
		return repository.findAll();
	}

	// READ BY ID
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	// UPDATE
	public User update(Long id, User newUser) {
		return repository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			return repository.save(user);
		}).orElseThrow();
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
