package com.electricity.electricity_house.repositories;

import com.electricity.electricity_house.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ArticuloRepository extends JpaRepository<Articulo, UUID> {

    @Query("SELECT MAX(a.nroArticulo) FROM Articulo a")
    Integer findMazNroArticulo();

}

