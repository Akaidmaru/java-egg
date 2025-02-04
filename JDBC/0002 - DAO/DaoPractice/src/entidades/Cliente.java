package entidades;

public class Cliente {
    private int idCliente;
    private int codigoCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
    private String fax;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int idEmpleado;
    private Double limiteCredito;

    public Cliente() {
    }

    public Cliente(int idCliente, int codigoCliente, String nombreCliente, String apellidoCliente, String telefono, String fax, String ciudad, String region, String pais, String codigoPostal, int idEmpleado, Double limiteCredito) {
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.idEmpleado = idEmpleado;
        this.limiteCredito = limiteCredito;
    }

    public Cliente(int codigoCliente, String nombreCliente, String apellidoCliente, String telefono, String fax, String ciudad, String region, String pais, String codigoPostal, int idEmpleado, Double limiteCredito) {
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.idEmpleado = idEmpleado;
        this.limiteCredito = limiteCredito;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
