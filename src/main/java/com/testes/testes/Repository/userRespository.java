package com.testes.testes.Repository;

import com.testes.testes.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRespository extends JpaRepository<user, Integer> {
}
