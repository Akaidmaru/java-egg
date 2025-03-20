package com.electricity.electricity_house.repositories;

import com.electricity.electricity_house.entities.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface FabricaRepository extends JpaRepository<Fabrica, UUID> {

    @Query("SELECT f FROM Fabrica f where f.nombreFabrica = :nombreFabrica")
    Fabrica findByName(@Param("nombreFabrica") String nombreFabrica);
}
