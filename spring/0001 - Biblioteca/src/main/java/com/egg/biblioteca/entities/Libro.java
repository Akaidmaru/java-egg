package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Libro {

    @Id
    private Long isbn;

    private String titulo;

    private Integer ejemplares;

    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editorial editorial;
}
