package com.egg.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Editoriales")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private int idEditorial;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "alta")
    private boolean alta;

    public Editorial() {
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "idEditorial=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }
}
