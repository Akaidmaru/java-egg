package com.egg.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long isbn;

    @Column(name="titulo")
    private String titulo;

    @Column(name="anio")
    private int anio;

    @Column(name="ejemplares")
    private int ejemplares;

    @Column(name="alta")
    private boolean alta;

    @ManyToOne()
    @JoinColumn(name="id_autor")
    private Autor autor;

    @ManyToOne()
    @Column(name="id_editorial")
    private Editorial editorial;

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", ejemplares=" + ejemplares +
                ", alta=" + alta +
                ", autor=" + autor +
                ", editorial=" + editorial +
                '}';
    }
}
