package main.java.com.backend.estancias.repository.ext;

import main.java.com.backend.estancias.entity.Estancia;
import main.java.com.backend.estancias.repository.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO {

    public Estancia registrarEstancia(Estancia estancia) throws Exception {
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)" +
                " VALUES(" +
                "'" + estancia.getIdCliente() + "'," +
                "'" + estancia.getIdCasa() + "'," +
                "'" + estancia.getNombreHuesped() + "'," +
                "'" + Date.valueOf(estancia.getFechaDesde()) + "'," +
                "'" + Date.valueOf(estancia.getFechaHasta()) + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Estancia> estanciasRegistradas = listarEstancias();
        return buscarEstancia(estanciasRegistradas.get(estanciasRegistradas.size() - 1).getIdEstancia());
    }

    public List<Estancia> listarEstancias() throws Exception {
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
        consultarDataBase(sql);

        List<Estancia> estancias = new ArrayList<>();
        while (resultSet.next()) {
            Estancia estancia = new Estancia();
            estancia.setIdEstancia(resultSet.getInt("id_estancia"));
            estancia.setIdCliente(resultSet.getInt("id_cliente"));
            estancia.setIdCasa(resultSet.getInt("id_casa"));
            estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
            estancia.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            estancia.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());

            estancias.add(estancia);
        }

        desconectarDataBase();
        return estancias;
    }

    public Estancia buscarEstancia(int idEstancia) throws Exception {
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias WHERE id_estancia=" + idEstancia;
        consultarDataBase(sql);

        Estancia estancia = new Estancia();
        while (resultSet.next()) {
            estancia.setIdEstancia(resultSet.getInt("id_estancia"));
            estancia.setIdCliente(resultSet.getInt("id_cliente"));
            estancia.setIdCasa(resultSet.getInt("id_casa"));
            estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
            estancia.setFechaDesde(resultSet.getDate("fecha_desde").toLocalDate());
            estancia.setFechaHasta(resultSet.getDate("fecha_hasta").toLocalDate());
        }

        desconectarDataBase();
        return estancia;
    }

    public boolean verificarDisponibilidadEstancia(Estancia estanciaBuscada) throws Exception {
        String sql = "SELECT COUNT(*) FROM estancias WHERE " +
                "id_casa = ? AND " +
                "(fecha_desde <= ? AND fecha_hasta >= ?)";

        prepareStatementInsertarModificarEliminarDataBase(sql);
        preparedStatement.setInt(1, estanciaBuscada.getIdCasa());
        preparedStatement.setDate(2, Date.valueOf(estanciaBuscada.getFechaDesde()));
        preparedStatement.setDate(3, Date.valueOf(estanciaBuscada.getFechaHasta()));

        try (ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0; // true, disponible
            }
        } catch (SQLException e) {
            throw new Exception("Error al verificar disponibilidad" + e.getMessage());
        }
        return false;
    }

    public Estancia actualizarEstancia(Estancia estancia, int idEstancia) throws Exception {
        String sql = "UPDATE estancias SET id_cliente=?, id_casa=?, nombre_huesped=?, fecha_desde=?, fecha_hasta=? WHERE id_estancia=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        System.out.println("EstanciaAActualizar = " + estancia);
        preparedStatement.setInt(1, estancia.getIdCliente());
        preparedStatement.setInt(2, estancia.getIdCasa());
        preparedStatement.setString(3, estancia.getNombreHuesped());
        preparedStatement.setDate(4, Date.valueOf(estancia.getFechaDesde()));
        preparedStatement.setDate(5, Date.valueOf(estancia.getFechaHasta()));
        preparedStatement.setInt(6, idEstancia);

        preparedStatement.executeUpdate();
        return buscarEstancia(idEstancia);
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        String sql = "DELETE from estancias WHERE id_estancia=" + idEstancia;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }
}
