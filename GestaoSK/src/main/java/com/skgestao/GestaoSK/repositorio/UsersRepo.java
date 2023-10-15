package com.skgestao.GestaoSK.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.skgestao.GestaoSK.model.Users;

public interface UsersRepo extends CrudRepository<Users, Integer> {

    // @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from tb_users where id = :id", nativeQuery = true)
    // public boolean exist(int id);

    @Query(value="select * from tb_users where email = :email and senha = :senha", nativeQuery = true)
    public Users login(String email, String senha);
    
}
