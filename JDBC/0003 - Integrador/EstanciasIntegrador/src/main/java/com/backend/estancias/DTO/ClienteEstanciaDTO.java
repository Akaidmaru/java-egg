package main.java.com.backend.estancias.DTO;

public class ClienteEstanciaDTO {
    private int idCliente;
    private String nombreCliente;
    private String nombreHuesped;
    private String fechaDesde;
    private String fechaHasta;
    private String tipoVivienda;

    public ClienteEstanciaDTO() {
    }

    public ClienteEstanciaDTO(String nombreCliente, String nombreHuesped, String fechaDesde, String fechaHasta, String tipoVivienda) {
        this.nombreCliente = nombreCliente;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tipoVivienda = tipoVivienda;
    }

    public ClienteEstanciaDTO(int idCliente, String nombreCliente, String nombreHuesped, String fechaDesde, String fechaHasta, String tipoVivienda) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tipoVivienda = tipoVivienda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Override
    public String toString() {
        return "ClienteEstanciaDTO{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreHuesped='" + nombreHuesped + '\'' +
                ", fechaDesde='" + fechaDesde + '\'' +
                ", fechaHasta='" + fechaHasta + '\'' +
                ", tipoVivienda='" + tipoVivienda + '\'' +
                '}';
    }
}
