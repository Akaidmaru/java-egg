package com.egg.entities;

import com.egg.entidades.GamaProducto;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad_en_stock")
    private int cantidadEnStock;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "precio_proveedor")
    private Double precioProveedor;

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }

    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", gamaProducto=" + gamaProducto +
                ", dimensiones='" + dimensiones + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadEnStock=" + cantidadEnStock +
                ", precioVenta=" + precioVenta +
                ", precioProveedor=" + precioProveedor +
                '}';
    }
}
