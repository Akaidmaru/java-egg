package com.electricity.electricity_house.services;

import com.electricity.electricity_house.entities.Fabrica;
import com.electricity.electricity_house.repositories.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FabricaService {
    @Autowired
    private FabricaRepository fabricaRepository;

    @Transactional
    public void createFabrica(String nombre) throws Exception {
        validate(nombre);

        Fabrica fabrica = new Fabrica();
        fabrica.setNombreFabrica(nombre);

        fabricaRepository.save(fabrica);
    }

    @Transactional(readOnly = true)
    public List<Fabrica> listarFabricas(){
        return fabricaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Fabrica getOne(UUID idFabrica){
        return fabricaRepository.findById(idFabrica).orElse(null);
    }

    @Transactional
    public Fabrica findByName(String nombre){
        return fabricaRepository.findByName(nombre);
    }

    public void modifyFabrica(UUID idFabrica, String nombre) throws Exception {
        validate(nombre);

        Optional<Fabrica> response = fabricaRepository.findById(idFabrica);

        if(response.isEmpty()){
            throw new Exception("La Fábrica que buscas no existe.");
        }

        Fabrica fabrica = response.get();
        fabrica.setNombreFabrica(nombre);

        fabricaRepository.save(fabrica);
    }


    public void validate(String nombre) throws Exception {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El nombre de la Fábrica no puede ser nulo o vacío");
        }
    }
}
