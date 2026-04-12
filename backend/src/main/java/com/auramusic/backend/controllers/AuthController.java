package com.auramusic.backend.controllers;

import com.auramusic.backend.dto.LoginRequest;
import com.auramusic.backend.entities.User;
import com.auramusic.backend.repositories.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	private final UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

		if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Login realizado com sucesso");
			response.put("username", userOpt.get().getUsername());
			response.put("role", userOpt.get().getRole());
			response.put("token", "fake-token-por-enquanto");
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
	}
}
