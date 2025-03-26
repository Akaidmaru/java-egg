package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void createAutor(String nombre){
        Autor autor = new Autor();

        autor.setNombre(nombre);

        autorRepository.save(autor);
    };

    @Transactional(readOnly = true)
    public List<Autor> listAutores(){
        return autorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Autor getOne(UUID idAutor){
        return autorRepository.getReferenceById(idAutor);
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id){
        
    }
}
