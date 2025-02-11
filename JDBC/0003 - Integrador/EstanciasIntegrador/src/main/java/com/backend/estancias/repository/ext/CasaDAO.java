package main.java.com.backend.estancias.repository.ext;


import main.java.com.backend.estancias.entity.Casa;
import main.java.com.backend.estancias.repository.DAO;

import java.sql.Date;
import java.util.ArrayList;
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
}
