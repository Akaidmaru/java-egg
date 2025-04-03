package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.services.AutorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private static final Logger logger = LoggerFactory.getLogger(AutorController.class);

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> crearAutor(@RequestParam @Valid String nombre){
        try {
            autorService.crearAutor(nombre);
            logger.info("Autor creado: " + nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        try {
            List<Autor> autores = autorService.listarAutores();
            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Autor> modificarAutor(
            @PathVariable UUID id, @RequestParam String nombre, @RequestParam Boolean activo
    ) throws Exception {
        try {
            autorService.modificarAutor(id, nombre, activo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
