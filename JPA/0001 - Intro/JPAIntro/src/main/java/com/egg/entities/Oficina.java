package com.egg.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina")
    private int idOficina;

    @Column(name = "codigo_oficina")
    private String codigoOficina;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;

    @Column(name = "region")
    private String region;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "telefono")
    private String telefono;

    public Oficina() {
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "idOficina=" + idOficina +
                ", codigoOficina='" + codigoOficina + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
