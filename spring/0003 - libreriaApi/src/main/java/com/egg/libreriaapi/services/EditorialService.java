package com.egg.libreriaapi.services;

import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.models.EditorialCreateDTO;
import com.egg.libreriaapi.repositories.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditorialService {

    private EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public Editorial crearEditorial(EditorialCreateDTO editorialCreateDTO){

        Editorial editorial = new Editorial();

        editorial.setNombre(editorialCreateDTO.getNombre());
        editorial.setActivo(editorialCreateDTO.isActivo());

        return editorialRepository.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        return editorialRepository.findAll();
    }

    public Optional<Editorial> findById(UUID id){
        return editorialRepository.findById(id);
    }

    public List<Editorial> listarEditorialesActivas() {
        return editorialRepository.findByActivo(true);
    }

    public List<Editorial> listarEditorialesInactivas() {
        return editorialRepository.findByActivo(false);
    }

    public Editorial modificarEditorial(UUID id, String nombre, boolean activo) throws Exception {

        Optional<Editorial> response = editorialRepository.findById(id);

        if (response.isPresent()){
            response.get().setNombre(nombre);
            response.get().setActivo(activo);

            return editorialRepository.save(response.get());
        } else {
            throw new Exception("No se encontró un editorial con el ID especificado.");
        }

    }
}
