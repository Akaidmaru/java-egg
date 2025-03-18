package com.electricity.electricity_house.repositories;

import com.electricity.electricity_house.entities.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FabricaRepository extends JpaRepository<Fabrica, UUID> {
}
