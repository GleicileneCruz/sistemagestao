package com.skgestao.GestaoSK.repositorio;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.skgestao.GestaoSK.model.Users;

import java.util.Optional;

public interface UsersRepo extends CrudRepository<Users, Integer> {

    @Query(value="select * from tb_user where email = :email and senha = :senha", nativeQuery = true)
    public Users login(String email, String senha);

    Optional<Object> findByEmail(String email);

    Object findAll(Sort id);

    Optional<Users> findByEmailIgnoreCaseAndIdNot(String email, int id);
}
