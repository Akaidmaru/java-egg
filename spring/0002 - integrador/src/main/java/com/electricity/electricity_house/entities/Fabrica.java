package com.electricity.electricity_house.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Fabrica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFabrica;

    @Column(nullable = false)
    private String nombreFabrica;
}
