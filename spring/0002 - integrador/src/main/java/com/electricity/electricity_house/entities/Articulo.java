package com.electricity.electricity_house.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Entity
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idArticulo;

    @Column(unique = true)
    private Integer nroArticulo;

    @Getter // Lombok no genera getters ni setter para campos estáticos, hay que especificalros
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Column(nullable = false)
    private String nombreArticulo;

    @Column(nullable = false)
    private String descripcionArticulo;

    @ManyToOne
    private Fabrica fabrica;

    public static void resetCounter(int value) {
        atomicInteger = new AtomicInteger(value);
    }


}
