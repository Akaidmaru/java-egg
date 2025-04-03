package com.egg.libreriaapi.services;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.entities.Libro;
import com.egg.libreriaapi.models.LibroCreateDTO;
import com.egg.libreriaapi.models.LibroModifyDTO;
import com.egg.libreriaapi.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class LibroService {

    LibroRepository libroRepository;
    AutorService autorService;
    EditorialService editorialService;

    public LibroService(LibroRepository libroRepository, AutorService autorRepository, EditorialService editorialService) {
        this.libroRepository = libroRepository;
        this.autorService = autorRepository;
        this.editorialService = editorialService;
    }

    public Libro crearLibro(LibroCreateDTO libroCreateDTO) {
        Libro libroNuevo = new Libro();
        libroNuevo.setIsbn(libroCreateDTO.getIsbn());
        libroNuevo.setTitulo(libroCreateDTO.getTitulo());
        libroNuevo.setEjemplares(libroCreateDTO.getEjemplares());
        libroNuevo.setActivo(libroCreateDTO.isActivo());
        libroNuevo.setAlta(LocalDate.now());

        Optional<Autor> autor = autorService.findById(libroCreateDTO.getIdAutor());
        autor.ifPresent(libroNuevo::setAutor);

        Optional<Editorial> editorial = editorialService.findById(libroCreateDTO.getIdEditorial());
        editorial.ifPresent(libroNuevo::setEditorial);

        return libroRepository.save(libroNuevo);
    }

    public Libro modificarLibro(LibroModifyDTO libroModifyDTO){
        Optional<Libro> response = libroRepository.findById(libroModifyDTO.getIsbn());

        if (response.isPresent()){
            response.get().setTitulo(libroModifyDTO.getTitulo());
            response.get().setEjemplares(libroModifyDTO.getEjemplares());
            response.get().setActivo(libroModifyDTO.isActivo());

            Optional<Autor> autor = autorService.findById(libroModifyDTO.getIdAutor());
            autor.ifPresent((response.get()::setAutor));

            Optional<Editorial> editorial = editorialService.findById(libroModifyDTO.getIdEditorial());
            editorial.ifPresent(response.get()::setEditorial);

            return libroRepository.save(response.get());
        }

        throw new IllegalArgumentException("Libro con ISBN " + libroModifyDTO.getIsbn() + " no encontrado.");
    }

    public List<Libro> listarLibros(){
        return libroRepository.findAll();
    }

    public List<Libro> listarLibrosActivos(){
        return libroRepository.findByActivo(true);
    }

    public List<Libro> listarLibrosInactivos(){
        return libroRepository.findByActivo(false);
    }
}
