package com.testes.testes.Controller;

import com.testes.testes.DTO.userDTO;
import com.testes.testes.Service.userService;
import com.testes.testes.domain.user;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    private userService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByID(@PathVariable Integer id) {
        Optional<user> user = userService.findById(id);
//        if (!user.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found");
//        }
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll() {
        List<user> user = userService.findAll();
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody userDTO userDTO){

        user user = new user();
        BeanUtils.copyProperties(userDTO,user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updtate(@PathVariable Integer id, @RequestBody userDTO userDTO){

        Optional<user> user = userService.findById(id);

        if(!user.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        user u1 = user.get();

        u1.setUserName(userDTO.getUserName());
        u1.setPassword(userDTO.getPassword());

        return ResponseEntity.ok().body(userService.save(u1));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletById(@PathVariable Integer id){


        Optional<user> user = userService.findById(id);

        if(!user.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");

        }

        userService.delet(id);

        return ResponseEntity.ok().body("Id deleted " + id);

    }

}
