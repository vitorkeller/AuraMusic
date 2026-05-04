package com.auramusic.backend.controllers;

import com.auramusic.backend.entities.User;
import com.auramusic.backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Teste unitário do AuthController usando @WebMvcTest
 * 
 * .\mvnw.cmd -Dtest=AuthControllerTest test
 * 
 * @WebMvcTest carrega APENAS o controller especificado e suas dependências
 *             diretas.
 *             Não sobe DataSource, não conecta no banco de dados real.
 * 
 *             UserRepository é mockado com @MockBean, permitindo controlar o
 *             comportamento
 *             em cada cenário de teste (login OK, senha errada, usuário não
 *             existe).
 */
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc; // Simula requisições HTTP (como o curl ou o navegador)

	@MockBean
	private UserRepository userRepository; // Mock do repositório - não acessa BD real

	/**
	 * Cenário: Login com credenciais válidas (admin/123)
	 * Esperado: Status 200 OK + JSON com username, role e token
	 */
	@Test
	public void deveRetornarSucesso_QuandoLoginEValido() throws Exception {
		// Arrange: Prepara um usuário mockado
		User usuarioAdmin = new User();
		usuarioAdmin.setId(1L);
		usuarioAdmin.setUsername("admin");
		usuarioAdmin.setPassword("123");
		usuarioAdmin.setEmail("admin@auramusic.com");
		usuarioAdmin.setRole("ADMIN");

		// Mock: quando findByUsername("admin") for chamado, retorna o usuário
		when(userRepository.findByUsername("admin")).thenReturn(Optional.of(usuarioAdmin));

		// Act & Assert: Envia requisição POST e valida resposta
		String jsonBody = "{\"username\":\"admin\",\"password\":\"123\"}";

		mockMvc.perform(post("/api/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
				.andExpect(status().isOk()) // Status 200
				.andExpect(jsonPath("$.username").value("admin"))
				.andExpect(jsonPath("$.role").value("ADMIN"))
				.andExpect(jsonPath("$.message").value("Login realizado com sucesso"));
	}

	/**
	 * Cenário: Login com senha inválida
	 * Esperado: Status 401 Unauthorized
	 */
	@Test
	public void deveRetornarNaoAutorizado_QuandoSenhaInvalida() throws Exception {
		// Arrange: Usuário existe, mas senha está diferente
		User usuarioAdmin = new User();
		usuarioAdmin.setId(1L);
		usuarioAdmin.setUsername("admin");
		usuarioAdmin.setPassword("123"); // Senha correta no banco
		usuarioAdmin.setEmail("admin@auramusic.com");
		usuarioAdmin.setRole("ADMIN");

		when(userRepository.findByUsername("admin")).thenReturn(Optional.of(usuarioAdmin));

		// Act & Assert: Tenta login com senha errada
		String jsonBody = "{\"username\":\"admin\",\"password\":\"senha_errada\"}";

		mockMvc.perform(post("/api/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
				.andExpect(status().isUnauthorized()); // Status 401
	}

	/**
	 * Cenário: Usuário não existe no banco
	 * Esperado: Status 401 Unauthorized
	 */
	@Test
	public void deveRetornarNaoAutorizado_QuandoUsuarioNaoExiste() throws Exception {
		// Arrange: Mock retorna empty quando usuário não existe
		when(userRepository.findByUsername("usuario_inexistente")).thenReturn(Optional.empty());

		// Act & Assert: Tenta login com usuário inexistente
		String jsonBody = "{\"username\":\"usuario_inexistente\",\"password\":\"qualquer_senha\"}";

		mockMvc.perform(post("/api/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody))
				.andExpect(status().isUnauthorized()); // Status 401
	}
}
