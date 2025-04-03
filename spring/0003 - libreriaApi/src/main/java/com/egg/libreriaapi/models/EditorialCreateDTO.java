package com.egg.libreriaapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditorialCreateDTO {
    private String nombre;
    private boolean activo;
}
