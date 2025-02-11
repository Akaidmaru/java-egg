package main.java.com.backend.estancias.repository.ext;


import main.java.com.backend.estancias.DTO.CasaComentarioDTO;
import main.java.com.backend.estancias.entity.Casa;
import main.java.com.backend.estancias.repository.DAO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasaDAO extends DAO {

    public Casa registrarCasa(Casa casa) throws Exception {
        String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)" +
                " VALUES(" +
                "'" + casa.getCalle() + "'," +
                "'" + casa.getNumero() + "'," +
                "'" + casa.getCodigoPostal() + "'," +
                "'" + casa.getCiudad() + "'," +
                "'" + casa.getPais() + "'," +
                "'" + Date.valueOf(casa.getFechaDesde()) + "'," +
                "'" + Date.valueOf(casa.getFechaHasta()) + "'," +
                "'" + casa.getTiempoMinimo() + "'," +
                "'" + casa.getTiempoMaximo() + "'," +
                "'" + casa.getPrecioHabitacion() + "'," +
                "'" + casa.getTipoVivienda() + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Casa> casasRegistradas = listarCasas();
        return buscarCasa(casasRegistradas.get(casasRegistradas.size() - 1).getIdCasa());
    }

    public List<Casa> listarCasas() throws Exception {
        String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas";
        consultarDataBase(sql);

        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            Casa casa = new Casa();
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
            casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

            casas.add(casa);
        }

        desconectarDataBase();
        return casas;
    }

    public List<Casa> listarCasasDisponiblesAgosto() throws Exception {
        String sql = "SELECT * FROM casas WHERE fecha_desde <= '2020-08-01' AND fecha_hasta >= '2020-08-31' AND pais='Reino Unido';";
        consultarDataBase(sql);

        List<Casa> casas = new ArrayList<>();
        while (resultSet.next()) {
            Casa casa = new Casa();
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
            casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

            casas.add(casa);
        }

        desconectarDataBase();
        return casas;
    }

    public List<Casa> listarCasasDisponiblesFechaEIntervaloDias(LocalDate fecha, int diasEstadia) throws Exception {
        String sql = "SELECT * FROM casas WHERE fecha_desde <= ? " +
                "AND fecha_hasta >= DATE_ADD(?, INTERVAL ? DAY)" +
                " AND tiempo_minimo <= ? AND tiempo_maximo >= ?";

        List<Object> parametros = Arrays.asList(
                Date.valueOf(fecha),
                Date.valueOf(fecha),
                diasEstadia,
                diasEstadia,
                diasEstadia
        );

        prepareStatementConsultarDataBase(sql, parametros);

        List<Casa> casas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

                casas.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al recorrer ResulSet: " + e.getMessage());
        } finally {
            desconectarDataBase();
        }

        return casas;

    }

    public Casa buscarCasa(int idCasa) throws Exception {
        String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas WHERE id_casa=" + idCasa;
        consultarDataBase(sql);

        Casa casa = new Casa();
        while (resultSet.next()) {
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
            casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
        }

        desconectarDataBase();
        return casa;
    }

    public Casa buscarCasaByAddress(Casa casaBuscada) throws Exception {
        String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas WHERE " +
                "pais=" + "'" + casaBuscada.getPais() + "'" + " AND " +
                "ciudad=" + "'" + casaBuscada.getCiudad() + "'" + " AND " +
                "calle=" + "'" + casaBuscada.getCalle() + "'" + " AND " +
                "numero=" + casaBuscada.getNumero();
        consultarDataBase(sql);

        Casa casa = new Casa();
        while (resultSet.next()) {
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCodigoPostal(resultSet.getString("codigo_postal"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
            casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
            casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
            casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
        }

        desconectarDataBase();
        return casa;
    }

    public Casa actualizarCasa(Casa casa, int idCasa) throws Exception {
        String sql = "UPDATE casas SET calle=?, numero=?, codigo_postal=?, ciudad=?, pais=?, fecha_desde=?, fecha_hasta=?, tiempo_minimo=?, tiempo_maximo=?, precio_habitacion=?, tipo_vivienda=? WHERE id_casa=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        System.out.println("casaAActualizar = " + casa.getCalle());
        preparedStatement.setString(1, casa.getCalle());
        preparedStatement.setInt(2, casa.getNumero());
        preparedStatement.setString(3, casa.getCodigoPostal());
        preparedStatement.setString(4, casa.getCiudad());
        preparedStatement.setString(5, casa.getPais());
        preparedStatement.setDate(6, Date.valueOf(casa.getFechaDesde()));
        preparedStatement.setDate(7, Date.valueOf(casa.getFechaHasta()));
        preparedStatement.setInt(8, casa.getTiempoMinimo());
        preparedStatement.setInt(9, casa.getTiempoMaximo());
        preparedStatement.setDouble(10, casa.getPrecioHabitacion());
        preparedStatement.setString(11, casa.getTipoVivienda());
        preparedStatement.setInt(12, idCasa);

        preparedStatement.executeUpdate();
        return buscarCasa(idCasa);
    }

    public void eliminarCasa(int idCasa) throws Exception {
        String sql = "DELETE from casas WHERE id_casa=" + idCasa;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }

    public void incrementarPrecioPorDia(double porcentaje, String pais) throws Exception {
        String sql = "UPDATE casas SET precio_habitacion = precio_habitacion + (precio_habitacion * ? / 100) " +
                "WHERE pais=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        preparedStatement.setDouble(1, porcentaje);
        preparedStatement.setString(2, pais);
        preparedStatement.executeUpdate();
    }

    public List<Casa> listarCasasPorPais(String pais) throws Exception {
        String sql = "SELECT * FROM casas WHERE Pais = ?";
        List<Object> parametros = Arrays.asList(pais);
        prepareStatementConsultarDataBase(sql, parametros);

        List<Casa> casas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Casa casa = new Casa();
                casa.setIdCasa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigoPostal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("ciudad"));
                casa.setPais(resultSet.getString("pais"));
                casa.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
                casa.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
                casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
                casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
                casa.setPrecioHabitacion(resultSet.getFloat("precio_habitacion"));
                casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

                casas.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al recorrer ResulSet: " + e.getMessage());
        } finally {
            desconectarDataBase();
        }

        return casas;
    }


    public void obtenerNumeroCasasPorPais() throws Exception {
        String sql = "SELECT pais, COUNT(*) as cantidad FROM casas GROUP BY pais";
        consultarDataBase(sql);

        while (resultSet.next()) {
            resultSet.getString("pais");
            resultSet.getInt("cantidad");
        }

        desconectarDataBase();
    }

    public List<CasaComentarioDTO> listarCasasReinoUnidoLimpias() throws Exception {
        String sql = "SELECT ca.id_casa, ca.pais, ca.ciudad, ca.calle, ca.numero , co.comentario " +
                "FROM casas ca JOIN comentarios co ON co.id_casa = ca.id_casa " +
                "WHERE pais='Reino Unido' and co.comentario like '%limpia%'";
        consultarDataBase(sql);

        List<CasaComentarioDTO> casasComentarios = new ArrayList<>();
        while (resultSet.next()) {
            CasaComentarioDTO dto = new CasaComentarioDTO();
            dto.setIdCasa(resultSet.getInt("id_casa"));
            dto.setPais(resultSet.getString("pais"));
            dto.setCiudad(resultSet.getString("ciudad"));
            dto.setCalle(resultSet.getString("calle"));
            dto.setNumero(resultSet.getInt("numero"));
            dto.setComentario(resultSet.getString("comentario"));

            casasComentarios.add(dto);
        }
        desconectarDataBase();
        return casasComentarios;
    }

}
