package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void createEditorial(String nombre){
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);

        editorialRepository.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listEditoriales(){
        return editorialRepository.findAll();
    }
}
