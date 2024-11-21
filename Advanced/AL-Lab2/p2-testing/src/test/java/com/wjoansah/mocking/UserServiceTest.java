package com.wjoansah.mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);

        userService = new UserService(userRepository);
    }

    @Test
    void getUser_WhenUserExists_ReturnsUser() {
        int userId = 1;
        String expectedUser = "Kwame";

        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        String actualUser = userService.getUser(userId);
        assertEquals(expectedUser, actualUser);

        verify(userRepository, times(1)).findUserById(userId);
    }

    @Test
    void getUser_WhenUserDoesNotExist_ReturnsNull() {
        int userId = 2;
        when(userRepository.findUserById(userId)).thenReturn(null);

        String actualUser = userService.getUser(userId);
        assertEquals("No such user", actualUser);

        verify(userRepository, times(1)).findUserById(userId);
    }
}