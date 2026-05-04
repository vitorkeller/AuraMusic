package com.auramusic.backend.services;

import com.auramusic.backend.entities.User;
import com.auramusic.backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Testes unitários para `UserService` usando Mockito.
 *
 * Este teste não sobe o contexto do Spring; usa apenas Mockito para
 * mockar o `UserRepository` e validar o comportamento da camada de serviço.
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void createUser_returnsSavedUser() {
		User toSave = new User();
		toSave.setUsername("user1");
		toSave.setPassword("pass");

		User saved = new User();
		saved.setId(1L);
		saved.setUsername("user1");
		saved.setPassword("pass");

		when(userRepository.save(any(User.class))).thenReturn(saved);

		User result = userService.create(toSave);

		assertNotNull(result);
		assertEquals(1L, result.getId());
		assertEquals("user1", result.getUsername());
		verify(userRepository).save(toSave);
	}

	@Test
	public void findAll_returnsList() {
		User a = new User();
		a.setId(1L);
		a.setUsername("a");
		User b = new User();
		b.setId(2L);
		b.setUsername("b");

		List<User> list = Arrays.asList(a, b);
		when(userRepository.findAll()).thenReturn(list);

		List<User> result = userService.findAll();

		assertEquals(2, result.size());
		assertEquals("a", result.get(0).getUsername());
	}

	@Test
	public void findById_foundAndNotFound() {
		User u = new User();
		u.setId(1L);
		u.setUsername("u");
		when(userRepository.findById(1L)).thenReturn(Optional.of(u));
		when(userRepository.findById(99L)).thenReturn(Optional.empty());

		Optional<User> ok = userService.findById(1L);
		Optional<User> missing = userService.findById(99L);

		assertTrue(ok.isPresent());
		assertEquals("u", ok.get().getUsername());
		assertTrue(missing.isEmpty());
	}

	@Test
	public void update_existingUser_updatesFields() {
		User existing = new User();
		existing.setId(1L);
		existing.setUsername("old");
		existing.setEmail("old@x.com");
		existing.setPassword("oldpass");

		User newUser = new User();
		newUser.setUsername("new");
		newUser.setEmail("new@x.com");
		newUser.setPassword("newpass");

		when(userRepository.findById(1L)).thenReturn(Optional.of(existing));
		when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArgument(0));

		User updated = userService.update(1L, newUser);

		assertEquals("new", updated.getUsername());
		assertEquals("new@x.com", updated.getEmail());
		assertEquals("newpass", updated.getPassword());
		verify(userRepository).findById(1L);
		verify(userRepository).save(existing);
	}

	@Test
	public void update_nonExisting_throws() {
		when(userRepository.findById(99L)).thenReturn(Optional.empty());

		assertThrows(NoSuchElementException.class, () -> userService.update(99L, new User()));
	}

	@Test
	public void delete_callsRepository() {
		doNothing().when(userRepository).deleteById(1L);

		userService.delete(1L);

		verify(userRepository).deleteById(1L);
	}
}
