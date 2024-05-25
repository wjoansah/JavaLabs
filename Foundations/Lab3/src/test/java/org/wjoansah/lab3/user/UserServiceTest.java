package org.wjoansah.lab3.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUsers_ShouldReturnAListOfUsers() {
        // Arrange
        var user1 = new User("user", "010-123-4567", "user@example.com");
        var user2 = new User("user", "010-123-4567", "user2@example.com");

        var users = List.of(user2, user1);
        when(userRepository.getUsers()).thenReturn(users);

        var userService = new UserService(userRepository);

        // Act
        var result = userService.getAllUsers();

        // Assert
        assertEquals(users, result);
        assertInstanceOf(List.class, result);
    }

    @Test
    void getUserByEmail_ShouldReturnAUser() {
        // Arrange
        var user1 = new User("user", "010-123-4567", "user@example.com");

        when(userRepository.getUserByEmail("user@example.com")).thenReturn(user1);

        var userService = new UserService(userRepository);

        // Act
        var result = userService.getUserByEmail("user@example.com");

        // Assert
        assertNotNull(result);
        assertEquals(user1, result);
    }

    @Test
    void addUser_WhenUserDoesNotExist_ShouldAddUser() {
        // Arrange
        String userEmail = "user@example.com";
        var user1 = new User("user", "010-123-4567", userEmail);

        when(userRepository.getUserByEmail(userEmail)).thenReturn(null);

        var userService = new UserService(userRepository);

        // Act
        userService.addUser(user1);

        // Assert
        verify(userRepository).addUser(user1);
    }

    @Test
    void addUser_WhenUserExists_ShouldThrowException() {
        // Arrange
        String email = "existinguser@example.com";
        var user = new User("user", "010-123-4567", email);
        when(userRepository.getUserByEmail(email)).thenReturn(user);

        var userService = new UserService(userRepository);

        // Act & Assert
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> userService.addUser(user));
        assertEquals("User already exists", thrown.getMessage());
        verify(userRepository, never()).addUser(user);
    }

    @Test
    void removeUser_WhenUserExists_ShouldRemoveUser() {
        // Arrange
        String email = "user@example.com";
        var user = new User("user", "010-123-4567", email);
        when(userRepository.getUserByEmail(email)).thenReturn(user);

        var userService = new UserService(userRepository);

        // Act
        userService.removeUser(email);

        // Assert
        verify(userRepository).removeUser(user);
    }

    @Test
    void removeUser_WhenUserDoesNotExist_ShouldDoNothing() {
        // Arrange
        String email = "nonexistentuser@example.com";
        when(userRepository.getUserByEmail(email)).thenReturn(null);

        var userService = new UserService(userRepository);

        // Act
        userService.removeUser(email);

        // Assert
        verify(userRepository, never()).removeUser(any(User.class));
    }

    @Test
    void updateUser_ShouldUpdateUser() {
    }
}