package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.entities.Libro;
import com.egg.libreriaapi.models.LibroCreateDTO;
import com.egg.libreriaapi.services.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    public LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<?> crearLibro(@RequestBody LibroCreateDTO libroCreateDTO){
        try {
            Libro libroCreado = libroService.crearLibro(libroCreateDTO);
            return ResponseEntity.ok(libroCreado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Algún dato no es correcto o es nulo, revisar"
                    + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarEditoriales(@RequestParam(required = false) Boolean activo){
        try{
            List<Libro> libros;
            if (activo == null) {
                libros = libroService.listarLibros();
            } else if (activo) {
                libros = libroService.listarLibrosActivos();
            } else {
                libros = libroService.listarLibrosInactivos();
            }
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
