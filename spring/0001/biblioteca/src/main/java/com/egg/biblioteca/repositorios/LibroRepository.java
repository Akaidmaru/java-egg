package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarPorTítulo(@Param("titulo") String titulo);
}
