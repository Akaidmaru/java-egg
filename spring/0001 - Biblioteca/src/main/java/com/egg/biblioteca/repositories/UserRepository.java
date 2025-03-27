package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Usuario, UUID> {

    @Query("SELECT u FROM Usuario WHERE email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);
}
