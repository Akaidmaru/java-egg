package com.egg.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEditorial;

    private String nombre;
}
