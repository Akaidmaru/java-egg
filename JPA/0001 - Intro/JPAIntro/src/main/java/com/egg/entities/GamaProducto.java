package com.egg.entidades;


import jakarta.persistence.*;


@Entity
@Table(name = "gama_producto")
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idGama;

    @Column(name = "descripcion_texto")
    private String descripcionTexto;

    @Column(name = "descripcion_html")
    private String descripcionHtml;

    @Column(name = "gama")
    private String gama;

    @Column(name = "imagen")
    private String imagen;


    public GamaProducto() {
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "GamaProducto{" +
                "idGama=" + idGama +
                ", descripcionTexto='" + descripcionTexto + '\'' +
                ", descripcionHtml='" + descripcionHtml + '\'' +
                ", gama='" + gama + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
