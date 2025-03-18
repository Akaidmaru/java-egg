package com.electricity.electricity_house.services;

import com.electricity.electricity_house.entities.Articulo;
import com.electricity.electricity_house.entities.Fabrica;
import com.electricity.electricity_house.repositories.ArticuloRepository;
import com.electricity.electricity_house.repositories.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private FabricaRepository fabricaRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void resetCounter() {
        Integer maxNroArticulo = articuloRepository.findMazNroArticulo();
        int initialValue = (maxNroArticulo != null) ? maxNroArticulo : 0;
        Articulo.resetCounter(initialValue);
    }


    @Transactional
    public void createArticulo(String nombre, String descripcion, UUID idFabrica) throws Exception {
        validate(nombre, descripcion, idFabrica);

        Fabrica fabrica = fabricaRepository.findById(idFabrica).get();

        Articulo articulo = new Articulo();
        articulo.setNombreArticulo(nombre);
        int newNroArticulo = Articulo.getAtomicInteger().incrementAndGet();
        articulo.setNroArticulo(newNroArticulo);
        articulo.setDescripcionArticulo(descripcion);
        articulo.setFabrica(fabrica);

        articuloRepository.save(articulo);
    }

    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Articulo getOne(UUID idArticulo) {
        return articuloRepository.findById(idArticulo).orElse(null);
    }

    @Transactional(readOnly = true)
    public Articulo findByName(String nombre) {
        return articuloRepository.findByName(nombre);
    }

    @Transactional
    public void modifyArticulo(UUID idArticulo, String nombre, String descripcion, UUID idFabrica) throws Exception {
        validate(nombre, descripcion, idFabrica);

        Optional<Articulo> response = articuloRepository.findById(idArticulo);
        Optional<Fabrica> responseFabrica = fabricaRepository.findById(idArticulo);

        if (response.isEmpty()) {
            throw new Exception("El artículo que buscas no existe.");
        }

        if (responseFabrica.isEmpty()) {
            throw new Exception("La fabrica que buscas no existe.");
        }

        Articulo articulo = response.get();
        articulo.setNombreArticulo(nombre);
        articulo.setDescripcionArticulo(descripcion);
        articulo.setFabrica(responseFabrica.get());

        articuloRepository.save(articulo);

    }


    private void validate(String nombre, String descripcion, UUID idFabrica) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre de la editorial no puede ser nulo o estar vacío.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new Exception("La descripción no puede ser nula o estar vacía");
        }
        if (idFabrica == null) {
            throw new Exception("El ID de la Fábrica no puede ser nulo o vacío");
        }
    }
}
