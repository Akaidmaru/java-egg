package com.egg.biblioteca.repositories;

import com.egg.biblioteca.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EditorialRepository extends JpaRepository<Editorial, UUID> {
}
