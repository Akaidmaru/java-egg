package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.repositories.AutorRepository;
import com.egg.biblioteca.repositories.EditorialRepository;
import com.egg.biblioteca.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void createLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial){
        Autor autor = autorRepository.findById(idAutor).get();

        Editorial editorial = editorialRepository.findById(idEditorial).get();

        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setFechaAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
    }

    @Transactional(readOnly = true)
    public List<Libro> listLibros(){
        return libroRepository.findAll();
    }

}
