package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.models.EditorialCreateDTO;
import com.egg.libreriaapi.models.EditorialDTO;
import com.egg.libreriaapi.services.EditorialService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    public EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @PostMapping
    public ResponseEntity<?> crearEditorial(@RequestBody EditorialCreateDTO editorialCreateDTO){
        try {
            Editorial editorial = editorialService.crearEditorial(editorialCreateDTO);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Algún dato no es correcto o es nulo, revisar"
            + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarEditoriales(@RequestParam(required = false) Boolean activo) {
        try{
            List<Editorial> editoriales;
            if (activo == null) {
                editoriales = editorialService.listarEditoriales();
            } else if (activo) {
                editoriales = editorialService.listarEditorialesActivas();
            } else {
                editoriales = editorialService.listarEditorialesInactivas();
            }
            return ResponseEntity.ok(editoriales);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Algún dato no es correcto o es nulo, revisar"
            + e.getMessage());
        }
    }

    // Revisa el output de los errores
    @GetMapping("/{id}")
    public ResponseEntity<?> listarEditorial(@PathVariable UUID id) {
        try {
            Optional<Editorial> editorialDTO = editorialService.findById(id);
            return ResponseEntity.ok(editorialDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra la Editorial-->" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modificarEditorial(
            @PathVariable UUID id,@RequestParam String nombre, @RequestParam Boolean activo
    ) {
        try {
            Editorial editorialModficado = editorialService.modificarEditorial(id, nombre, activo);
            return ResponseEntity.ok(editorialModficado);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Algún dato no es correcto o es nulo, revisar"
                    + e.getMessage());
        }
    }
}
