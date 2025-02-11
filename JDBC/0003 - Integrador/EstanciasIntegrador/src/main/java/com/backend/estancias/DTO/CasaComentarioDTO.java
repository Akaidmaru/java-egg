package main.java.com.backend.estancias.DTO;

public class CasaComentarioDTO {
    private int idCasa;
    private String pais;
    private String ciudad;
    private String calle;
    private int numero;
    private String comentario;

    public CasaComentarioDTO() {
    }

    public CasaComentarioDTO(String pais, String ciudad, String calle, int numero, String comentario) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.comentario = comentario;
    }

    public CasaComentarioDTO(int idCasa, String pais, String ciudad, String calle, int numero, String comentario) {
        this.idCasa = idCasa;
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.comentario = comentario;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "CasaComentarioDTO{" +
                "idCasa=" + idCasa +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
