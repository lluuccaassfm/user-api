package com.userapi.controller;

import com.userapi.model.User;
import com.userapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class UserControlleTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testFindAllUsers() {
        List<User> list = List.of(userMock());
        when(userService.findAllUsers()).thenReturn(list);
        List<User> listResponse = userController.findAllUsers().getBody();
        assertEquals(list, listResponse);
    }

    @Test
    public void testFindById() throws Exception {
        User user = userMock();
        when(userService.findById(anyString())).thenReturn(user);
        User userResponse = userController.findById(user.getId()).getBody();
        assertEquals(user, userResponse);
    }

    @Test
    public void testFindByName() throws Exception {
        User user = userMock();
        when(userService.findByName(anyString())).thenReturn(user);
        User userResponse = userController.findByName(user.getName()).getBody();
        assertEquals(user, userResponse);
    }

    @Test
    public void testFindByCod() throws Exception {
        User user = userMock();
        when(userService.findByCodUser(anyLong())).thenReturn(user);
        User userResponse = userController.findByCodUser(user.getCodUser()).getBody();
        assertEquals(user, userResponse);
    }

    @Test
    public void testCreateUser() {
        User user = userMock();
        when(userService.createUser(user)).thenReturn(user);
        assertNotNull(userController.create(user));
    }

    @Test
    public void testCreateUserWithoutName() {
        User userRequest = userMock();
        userRequest.setName(null);
        assertEquals(HttpStatus.BAD_REQUEST, userController.create(userRequest).getStatusCode());
    }

    @Test
    public void testUpdateUser() {
        assertEquals(HttpStatus.OK, userController.update(userMock()).getStatusCode());
    }

    @Test
    public void testDeleteUser() {
        assertEquals(HttpStatus.OK, userController.delete(anyString()).getStatusCode());
    }

    private User userMock() {
        return User.builder()
                .id("a1")
                .name("User teste")
                .codUser(154L)
                .email("teste@email.com")
                .build();
    }
}
