package com.auramusic.backend.domain.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	// CREATE
	@PostMapping
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	// READ ALL
	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	// READ BY ID
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow();
	}

	// UPDATE
	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		return service.update(id, user);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
