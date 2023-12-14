package com.ada.ProjetoFinalProgramacaoWeb2.repository;

import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    @Query(value = "SELECT * FROM USERS WHERE ACTIVE = TRUE", nativeQuery = true)
    Page<User> findAll (Pageable pageable);

    User findByEmail(String email);


    List<User> findAllByName(String name);

    @Query(value = "SELECT * FROM USERS WHERE CPF = :userCpf", nativeQuery = true)
    User findUserByCpf(String userCpf);

}
