package main.java.com.backend.estancias.entity;

import java.time.LocalDate;

public class Estancia {
    private int idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombreHuesped;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

    public Estancia() {
    }

    public Estancia(String nombreHuesped, LocalDate fechaDesde, LocalDate fechaHasta) {
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Estancia(int idCliente, int idCasa, String nombreHuesped, LocalDate fechaDesde, LocalDate fechaHasta) {
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Estancia{" +
                "idEstancia=" + idEstancia +
                ", idCliente=" + idCliente +
                ", idCasa=" + idCasa +
                ", nombreHuesped='" + nombreHuesped + '\'' +
                ", fechaDesde=" + fechaDesde +
                ", fechaHasta=" + fechaHasta +
                '}';
    }
}
