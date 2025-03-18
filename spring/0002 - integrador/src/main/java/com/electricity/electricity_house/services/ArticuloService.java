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
        int initialValue = (maxNroArticulo != null ) ? maxNroArticulo : 0;
        Articulo.resetCounter(initialValue);
    }


    @Transactional
    public void createArticulo(String nombre, String descripcion, UUID idFabrica) throws Exception {
        validate(nombre);
        Fabrica fabrica = fabricaRepository.findById(idFabrica).get();

        Articulo articulo = new Articulo();
        articulo.setNombreArticulo(nombre);
        int newNroArticulo = Articulo.getAtomicInteger().incrementAndGet();
        articulo.setNroArticulo(newNroArticulo);
        articulo.setDescripcionArticulo(descripcion);
        articulo.setFabrica(fabrica);;

        articuloRepository.save(articulo)

    }


    private void validate(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El nombre de la editorial no puede ser nulo o estar vacío.");
        }
    }
}
