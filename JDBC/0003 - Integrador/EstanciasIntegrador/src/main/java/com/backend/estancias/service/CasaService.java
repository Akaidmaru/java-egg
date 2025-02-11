package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.DTO.CasaComentarioDTO;
import main.java.com.backend.estancias.entity.Casa;
import main.java.com.backend.estancias.repository.ext.CasaDAO;

import java.time.LocalDate;
import java.util.List;

public class CasaService {
    private CasaDAO casaDAO;

    public CasaService() {
        this.casaDAO = new CasaDAO();
    }

    public List<Casa> listarCasas() throws Exception {
        List<Casa> casas = casaDAO.listarCasas();
        for (Casa casa : casas) {
            System.out.println(casa);
        }
        return casas;
    }

    public List<Casa> listarCasasDisponiblesAgosto() throws Exception {
        List<Casa> casas = casaDAO.listarCasasDisponiblesAgosto();
        for (Casa casa : casas) {
            System.out.println(casa);
        }
        return casas;
    }

    public List<Casa> listarCasasDisponiblesFechaEIntervaloDias(LocalDate fecha, int diasEstadia) throws Exception {
        List<Casa> casas = casaDAO.listarCasasDisponiblesFechaEIntervaloDias(fecha, diasEstadia);
        for (Casa casa : casas) {
            System.out.println(casa);
        }
        return casas;
    }

    public Casa registrarCasa(Casa casa) throws Exception {
        Casa casaBuscada = casaDAO.buscarCasaByAddress(casa);
        System.out.println("casaBuscada = " + casaBuscada);
        if (casaBuscada.getIdCasa() != 0) {
            if (casaBuscada.getPais().equals(casa.getPais())
                    && casaBuscada.getCiudad().equals(casa.getCiudad())
                    && casaBuscada.getCalle().equals(casa.getCalle())
                    && casaBuscada.getNumero() == casa.getNumero()
            ) {
                throw new RuntimeException("No se pudo registrar la casa pq existe en el sistema");
            }
        }

        Casa casaARegistrada = casaDAO.registrarCasa(casa);
        return casaARegistrada;
    }

    public Casa buscarCasa(int idCasa) throws Exception {
        Casa casabuscada = casaDAO.buscarCasa(idCasa);
        return casabuscada;
    }

    public Casa actualizarCasa(Casa casa, int idCasa) throws Exception {

        if (buscarCasa(idCasa).getIdCasa() == 0) {
            throw new RuntimeException("No se pudo actualiza la casa pq no existe en el sistema");
        }

        Casa casaActualizada = casaDAO.actualizarCasa(casa, idCasa);
        return casaActualizada;

    }

    public void eliminarCasa(int idCasa) throws Exception {
        if (buscarCasa(idCasa).getIdCasa() == 0) {
            throw new RuntimeException("No se pudo eliminar la casa pq no existe en el sistema");
        }

        casaDAO.eliminarCasa(idCasa);

    }

    public List<Casa> listarCasasPorPais(String pais) throws Exception {
        List<Casa> casas = casaDAO.listarCasasPorPais(pais);
        for (Casa casa : casas) {
            System.out.println(casa);
        }
        return casas;
    }

    public void incrementarPrecioPorDia(double porcentaje, String pais) throws Exception {
        casaDAO.incrementarPrecioPorDia(porcentaje, pais);
        System.out.println("Precio por día incrementado, se procede a mostrar los precios actualizados.");
        listarCasasPorPais(pais);
    }

    public void obtenerNumeroCasasPorPais() throws Exception {
        casaDAO.obtenerNumeroCasasPorPais();
    }

    public List<CasaComentarioDTO> listarCasasReinoUnidoLimpias() throws Exception {
        List<CasaComentarioDTO> casas = casaDAO.listarCasasReinoUnidoLimpias();
        for (CasaComentarioDTO casa : casas) {
            System.out.println(casa);
        }
        return casas;
    }
}
