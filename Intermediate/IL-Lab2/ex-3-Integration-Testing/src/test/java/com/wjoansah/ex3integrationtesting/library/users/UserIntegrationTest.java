package com.wjoansah.ex3integrationtesting.library.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class UserIntegrationTest {

    @Test
    public void testCreateUserAccount() {
        // Stub for UserRepository (simulating database interaction)
        UserRepository userRepositoryStub = mock(UserRepository.class);

        // Sample user data
        User user = new User("john_doe", "john.doe@email.com", "John Doe");

        // Stub behavior: return the user when saved
        when(userRepositoryStub.save(any(User.class))).thenReturn(user);

        // Service layer that uses the stubbed repository
        UserService userService = new UserService(userRepositoryStub);

        // Create a new user account
        User createdUser = userService.createUser("john_doe", "password123", "John Doe");

        // Assert that the created user matches the expected data
        assertEquals("john_doe", createdUser.getUsername());
        assertEquals("John Doe", createdUser.getFullName());
    }
}