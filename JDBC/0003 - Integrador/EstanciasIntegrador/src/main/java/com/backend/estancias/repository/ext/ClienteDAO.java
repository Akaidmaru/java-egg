package main.java.com.backend.estancias.repository.ext;

import main.java.com.backend.estancias.entity.Cliente;
import main.java.com.backend.estancias.repository.DAO;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public Cliente registrarCliente(Cliente cliente) throws Exception {
        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES(" +
                "'" + cliente.getNombre() + "'," +
                "'" + cliente.getCalle() + "'," +
                "'" + cliente.getNumero() + "'," +
                "'" + cliente.getCodigoPostal() + "'," +
                "'" + cliente.getCiudad() + "'," +
                "'" + cliente.getPais() + "'," +
                "'" + cliente.getEmail() + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Cliente> clientesRegistrados = listarClientes();
        return buscarCliente(clientesRegistrados.get(clientesRegistrados.size() - 1).getIdCliente());
    }

    public List<Cliente> listarClientes() throws Exception {
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes";
        consultarDataBase(sql);

        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setCalle(resultSet.getString("calle"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setEmail(resultSet.getString("email"));

            clientes.add(cliente);
        }

        desconectarDataBase();
        return clientes;
    }

    public Cliente buscarCliente(int idCliente) throws Exception {
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes WHERE id_cliente=" + idCliente;
        consultarDataBase(sql);

        Cliente cliente = new Cliente();
        while (resultSet.next()) {
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setCalle(resultSet.getString("calle"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setEmail(resultSet.getString("email"));
        }

        desconectarDataBase();
        return cliente;
    }

    public Cliente actualizarCliente(Cliente cliente, int idCliente) throws Exception {
        String sql = "UPDATE clientes SET nombre=?, calle=?, numero=?, codigo_postal=?, ciudad=?, pais=?, email=? WHERE id_cliente=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getCalle());
        preparedStatement.setInt(3, cliente.getNumero());
        preparedStatement.setString(4, cliente.getCodigoPostal());
        preparedStatement.setString(5, cliente.getCiudad());
        preparedStatement.setString(6, cliente.getPais());
        preparedStatement.setString(7, cliente.getEmail());
        preparedStatement.setInt(8, idCliente);

        preparedStatement.executeUpdate();
        return buscarCliente(idCliente);
    }

    public void eliminarCliente(int idCliente) throws Exception {
        String sql = "DELETE from clientes WHERE id_cliente=" + idCliente;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }


    public Cliente buscarClienteByEmail(String email) throws Exception {
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes WHERE email='" + email + "'";
        consultarDataBase(sql);

        Cliente cliente = null;
        if (resultSet.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setCalle(resultSet.getString("calle"));
            cliente.setNumero(resultSet.getInt("numero"));
            cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
            cliente.setCiudad(resultSet.getString("ciudad"));
            cliente.setPais(resultSet.getString("pais"));
            cliente.setEmail(resultSet.getString("email"));
        }

        desconectarDataBase();
        return cliente;
    }
}
