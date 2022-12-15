package com.testes.testes.Service;

import com.testes.testes.DTO.userDTO;
import com.testes.testes.Repository.userRespository;
import com.testes.testes.domain.user;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class userServiceTest {

    @InjectMocks
    private userService userService;

    @Mock
    private com.testes.testes.domain.user user;

    @Mock
    private userRespository userRespository;

    private userDTO userDTO;


    private Optional<user> userOptional;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void buscarInstanciaDeUsuario() {

        Mockito.when(userRespository.findById(Mockito.anyInt())).thenReturn(userOptional);

        Optional<com.testes.testes.domain.user> response = userService.findById(1);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.get().getId());
    }

    @Test
    void findAll() {

        Mockito.when(userRespository.findAll()).thenReturn(List.of(user));

        List<user> response = userService.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(com.testes.testes.domain.user.class, response.get(0).getClass());

    }

    @Test
    void save() {
    }

    @Test
    void delet() {
    }

    private void startUser(){

        user = new user(1, "wesley", "80340");
        userDTO = new userDTO(1, "wesley", "80340");
        userOptional = Optional.of(new user(1, "wesley", "80340"));

    }
}