package com.testes.testes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
public class userDTO {


    private Integer id;

    @Column(unique = true)
    private String userName;
    private String password;



}
