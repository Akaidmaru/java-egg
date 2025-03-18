package main.java.com.backend.last.entity;

public class Autos {
    private int idAuto;
    private int idPropietario;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private double precio;

    public Autos() {
    }

    public Autos(int idPropietario, String marca, String modelo, int anio, String color, double precio) {
        this.idPropietario = idPropietario;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
    }

    public Autos(int idAuto, int idPropietario, String marca, String modelo, int anio, String color, double precio) {
        this.idAuto = idAuto;
        this.idPropietario = idPropietario;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.precio = precio;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Autos{" +
                "idAuto=" + idAuto +
                ", idPropietario=" + idPropietario +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }
}
