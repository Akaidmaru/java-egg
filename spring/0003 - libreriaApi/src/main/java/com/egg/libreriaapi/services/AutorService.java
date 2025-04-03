package com.egg.libreriaapi.services;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor crearAutor(String nombre) {

        Autor autor = new Autor();

        autor.setNombre(nombre);
        autor.setActivo(true);

        return autorRepository.save(autor);
    }

    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(UUID id){
        return autorRepository.findById(id);
    }

    public Autor modificarAutor(UUID id, String nombre, boolean activo) throws Exception{

        Optional<Autor> response = autorRepository.findById(id);

        if (response.isPresent()){
            response.get().setNombre(nombre);
            response.get().setActivo(activo);

            return autorRepository.save(response.get());
        } else {
            throw new Exception("No se encontró un autor con el ID especificado.");
        }
    }

    public void eliminar(UUID id) throws Exception {

        Optional<Autor> response = autorRepository.findById(id);

        if (response.isPresent()){
            response.get().setActivo(!response.get().isActivo());

            autorRepository.save(response.get());
        } else {
            throw new Exception("No se encontró un autor con el ID especificado.");
        }
    }


}
