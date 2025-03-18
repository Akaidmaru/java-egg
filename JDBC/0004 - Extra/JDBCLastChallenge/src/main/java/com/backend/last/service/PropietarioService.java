package main.java.com.backend.last.service;

import main.java.com.backend.last.repository.ext.PropietarioDAO;
import main.java.com.backend.last.entity.Propietarios;

public class PropietarioService {
    private PropietarioDAO propietarioDAO;

    public PropietarioService() {
        this.propietarioDAO = new PropietarioDAO();
    }

    public Propietarios registrarPropietario(Propietarios propietario) throws Exception {
        Propietarios propietarioBuscado = propietarioDAO.buscarPropietario(propietario);

        return propietarioDAO.registrarPropietario(propietario);
    }
}
