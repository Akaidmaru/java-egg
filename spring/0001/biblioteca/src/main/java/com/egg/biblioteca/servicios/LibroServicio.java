package com.egg.biblioteca.servicios;


import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    AutorServicio autorService;

    @Autowired
    EditorialServicio editorialService;

    @Transactional
    public void crearLibro(String nombre, Long isbn, String nombreAutor, String nombreEditorial, String ejemplares ){
        Autor autor = autorService.buscarPorNombre(nombreAutor);
        if (autor == null){
            autorService.crearAutor(nombreAutor);
            autor = autorService.buscarPorNombre(nombreAutor);
        }

        Editorial editoral = editorialService.buscarPorNombre(nombreEditorial);
        if (editoral == null){
            editorialService.crearEditorial(nombreEditorial);
        }

        Libro libro = new Libro();
        libro.setName(nombre);
        libro.setIsbn(isbn);
        libro.setAutor(autor);
        libro.setEditorial();
        libro.setEjemplares(ejemplares);
        libroRepository.save(libro);
    }



}
