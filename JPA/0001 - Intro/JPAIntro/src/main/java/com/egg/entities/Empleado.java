package com.egg.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "empleado")
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;


    @Column(name = "apellido", length = 50)
    private String apellido;


    @Column(name = "codigo_empleado")
    private int codigoEmpleado;


    @Column(name = "email", length = 100)
    private String email;


    @Column(name = "extension", length = 10)
    private String extension;


    @Column(name = "id_jefe")
    private int idJefe;


    @Column(name = "nombre", length = 50)
    private String nombre;


    @Column(name = "puesto")
    private String puesto;


    @ManyToOne
    @JoinColumn(name = "id_oficina")
    private Oficina Oficina;


    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Oficina getOficina() {
        return Oficina;
    }

    public void setOficina(Oficina oficina) {
        Oficina = oficina;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", apellido='" + apellido + '\'' +
                ", codigoEmpleado=" + codigoEmpleado +
                ", email='" + email + '\'' +
                ", extension='" + extension + '\'' +
                ", idJefe=" + idJefe +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", Oficina=" + Oficina +
                '}';
    }
}
