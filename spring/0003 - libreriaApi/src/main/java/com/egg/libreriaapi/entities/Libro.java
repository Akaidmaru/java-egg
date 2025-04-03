package com.egg.libreriaapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @NotBlank
    private String isbn;

    @NotBlank
    private String titulo;

    private Integer ejemplares = 1;

    @Temporal(TemporalType.DATE)
    private LocalDate alta;

    @Column(nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="editorial_id")
    private Editorial editorial;

}

