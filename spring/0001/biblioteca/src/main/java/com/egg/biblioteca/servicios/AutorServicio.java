package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void crearAutor(String nombre){
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepository.save(autor);
    }

    public Autor buscarPorNombre(String nombre){
        return autorRepository.buscarPorNombre(nombre);
    }
}
