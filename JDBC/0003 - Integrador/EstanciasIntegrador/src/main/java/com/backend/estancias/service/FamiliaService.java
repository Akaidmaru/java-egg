package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.entity.Estancia;
import main.java.com.backend.estancias.entity.Familia;
import main.java.com.backend.estancias.repository.ext.FamiliaDAO;

import java.util.List;

public class FamiliaService {

    private FamiliaDAO familiaDAO;

    public FamiliaService() {
        this.familiaDAO = new FamiliaDAO();;
    }

    public List<Familia> listarFamilias () throws Exception {
        List<Familia> familiaList = familiaDAO.listarFamilias();
        for (Familia familia : familiaList) {
            System.out.println("familia = " + familia);
        }


        return familiaList;

    }

    public Familia registrarFamilia(Familia familia) throws Exception {

        System.out.println("familiaARegistrar = " + familia);
        if (familiaDAO.buscarFamiliaByName(familia.getNombre())){
            throw new RuntimeException("No se pudo registrar la familia pq ya existe el sistema");
        }
        Familia familiaARegistrada = familiaDAO.registrarFamilia(familia);
        System.out.println("familiaARegistrada = " + familiaARegistrada);
        return familiaARegistrada;
    }

    public Familia buscarFamilia(int idFamilia) throws Exception {

        Familia familiabuscada = familiaDAO.buscarFamilia(idFamilia);
        System.out.println("familiabuscada = " + familiabuscada);
        return familiabuscada;
    }

    public Familia actualizarFamilia(Familia familia, int idFamilia) throws Exception {

        if(buscarFamilia(idFamilia).getIdFamilia()==0){
            throw new RuntimeException("No se pudo actualizar la Familia pq existe en el sistema");
        }

        Familia familiaActualizada = familiaDAO.actualizarFamilia(familia,idFamilia);
        System.out.println("familiaActualizada = " + familiaActualizada);
        return familiaActualizada;

    }

    public void eliminarFamilia(int idFamilia) throws Exception {
        if (buscarFamilia(idFamilia).getIdFamilia()==0) {
            throw new RuntimeException("No se pudo elimiar la Familia pq no existe en el sistema");
        }

        familiaDAO.eliminarFamilia(idFamilia);
        System.out.println("Familia eliminada con id = " + idFamilia);

    }

}
