package com.testes.testes.Service;

import com.testes.testes.DTO.userDTO;
import com.testes.testes.Repository.userRespository;
import com.testes.testes.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class userService {

    @Autowired
    private userRespository userRespository;


    @Transactional
    public Optional<user> findById(Integer id){

        return  userRespository.findById(id);

    }

    @Transactional
    public List<user> findAll(){

        return userRespository.findAll();
    }

    @Transactional
    public user save(user user){

       return userRespository.save(user);
    }

    @Transactional
    public void delet(Integer id){

        userRespository.deleteById(id);

    }

}
