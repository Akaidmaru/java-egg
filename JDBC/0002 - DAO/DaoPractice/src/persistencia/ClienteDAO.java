package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;

public class ClienteDAO extends DAO {
    /*
     * Crea una sentencia SQL para insertar los valores de los campos del objeto
     * Cliente. Usa los métodos get del objeto Cliente para obtener los valores
     * correspondientes.
     *
     * Llamado al método insertarModificarEliminarDataBase(): Utiliza el método
     * heredado de la clase abstracta DAO para ejecutar la sentencia SQL.
     *
     * Manejo de excepciones: Asegúrate de manejar las excepciones, como
     * SQLException, que podrían ocurrir durante la ejecución de la sentencia SQL.
     * Captura estas excepciones y maneja el error de forma adecuada, por ejemplo,
     * registrando el error o lanzando una excepción personalizada.
     */
    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO cliente (nombre_cliente, apellido_contacto, telefono) VALUES ('"     + cliente.getNombreCliente() + "', '"
                + cliente.getApellidoContacto() + "', '"
                + cliente.getTelefono() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Cliente> listarTodosLosClientes() throws Exception {
        String sql = "SELECT id_cliente, nombre_cliente, apellido_contacto, telefono FROM cliente";
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
            cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
            cliente.setTelefono(resultSet.getString("telefono"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public void  eliminarClientePorId(int id) throws Exception {
        String sql = "DELETE FROM cliente WHERE id = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigo;
        consultarDataBase(sql);
        Cliente cliente = null;
        if(resultSet.next()){
            cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
            cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
            cliente.setTelefono(resultSet.getString("telefono"));
        }
        return cliente;
    }
}

