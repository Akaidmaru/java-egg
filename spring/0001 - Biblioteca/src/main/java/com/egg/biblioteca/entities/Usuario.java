package com.egg.biblioteca.entities;

import com.egg.biblioteca.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUsuario;

    private String nombre;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role rol;

}
