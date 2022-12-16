package com.testes.testes.Service;

import com.testes.testes.DTO.userDTO;
import com.testes.testes.Repository.userRespository;
import com.testes.testes.domain.user;
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


        Mockito.when(userRespository.save(user)).thenReturn(user);

        user reponse =  userService.save(user);

        Assertions.assertNotNull(reponse);
        Assertions.assertEquals(com.testes.testes.domain.user.class, reponse.getClass());
        Assertions.assertEquals(user.getId(), reponse.getId());
        Assertions.assertEquals(user.getUserName(), reponse.getUserName());
        Assertions.assertEquals(user.getPassword(), reponse.getPassword());
    }

    @Test
    void delet() {

        Mockito.when(userRespository.findById(Mockito.anyInt())).thenReturn(userOptional);

        Mockito.doNothing().when(userRespository).deleteById(Mockito.anyInt());

        userService.delet(user.getId());

        Mockito.verify(userRespository,Mockito.times(1)).deleteById(Mockito.anyInt());


    }

    private void startUser(){

        user = new user(1, "wesley", "80340");
        userDTO = new userDTO(1, "wesley", "80340");
        userOptional = Optional.of(new user(1, "wesley", "80340"));

    }
}