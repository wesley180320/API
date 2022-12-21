package com.testes.testes.Controller;

import com.testes.testes.DTO.userDTO;
import com.testes.testes.Service.userService;
import com.testes.testes.domain.user;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class userControllerTest {


    @InjectMocks
    private userController controller;

    @Mock
    private userService userService;

    @Mock
    private com.testes.testes.domain.user user;

    @Mock
    private com.testes.testes.Repository.userRespository userRespository;

    @Mock
    private userDTO userDTO;


    private Optional<user> userOptional;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void findByID() {

        Mockito.when(userService.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));

        ResponseEntity<Object> reponse = controller.findByID(1);

        Assertions.assertNotNull(reponse);
        Assertions.assertNotNull(reponse.getBody());

        Assertions.assertEquals(ResponseEntity.class, reponse.getClass());
        Assertions.assertEquals(Optional.ofNullable(user).getClass(), reponse.getBody().getClass());


    }

    @Test
    void findAll() {

        Mockito.when(userService.findAll()).thenReturn(List.of(user));

        List<com.testes.testes.domain.user> users =  userService.findAll();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user.getClass(), users.get(0).getClass());

    }

    @Test
    void save() {
    }

    @Test
    void updtate() {
    }

    @Test
    void deletById() {
    }

    private void startUser(){

        user = new user(1, "wesley", "80340");
        userDTO = new userDTO(1, "wesley", "80340");
        userOptional = Optional.of(new user(1, "wesley", "80340"));

    }

}