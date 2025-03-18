package com.electricity.electricity_house.repositories;

import com.electricity.electricity_house.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ArticuloRepository extends JpaRepository<Articulo, UUID> {

    @Query("SELECT MAX(a.nroArticulo) FROM Articulo a")
    Integer findMazNroArticulo();

    @Query("SELECT a FROM Articulo a WHERE a.nombre = :nombre")
    Articulo findByName(@Param("nombre") String nombre);
}

