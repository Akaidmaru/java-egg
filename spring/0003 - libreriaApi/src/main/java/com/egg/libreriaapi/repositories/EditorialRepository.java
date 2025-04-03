package com.egg.libreriaapi.repositories;


import com.egg.libreriaapi.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, UUID> {
    List<Editorial> findByActivo(Boolean activo);
}
