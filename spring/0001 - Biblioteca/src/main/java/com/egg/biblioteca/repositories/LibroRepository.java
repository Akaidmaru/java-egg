package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l from Libro l WHERE titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT l from Libro l WHERE autor = :autor")
    public List<Libro> buscarLibrosPorAutor(@Param("autor") String autor);
}
