package com.egg.libreriaapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LibroCreateDTO {
    private String isbn;
    private String titulo;
    private Integer ejemplares;
    private boolean activo;
    private UUID idAutor;
    private UUID idEditorial;
}
