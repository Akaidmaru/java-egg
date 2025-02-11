package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.DTO.ClienteEstanciaDTO;
import main.java.com.backend.estancias.entity.Cliente;
import main.java.com.backend.estancias.repository.ext.ClienteDAO;

import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public List<Cliente> listarClientes() throws Exception {
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("cliente = " + cliente);
        }
        return clientes;
    }

    public List<ClienteEstanciaDTO> listarClientesEstanciaPrevia() throws Exception {
        List<ClienteEstanciaDTO> clientesEstanciaDTO = clienteDAO.listarClientesEstanciaPrevia();
        for (ClienteEstanciaDTO cliente : clientesEstanciaDTO) {
            System.out.println(cliente);
        }
        return clientesEstanciaDTO;
    }

    public Cliente registrarCliente(Cliente cliente) throws Exception {
        if (clienteDAO.buscarClienteByEmail(cliente.getEmail()) != null) {
            throw new RuntimeException("No se pudo registrar el cliente porque ya existe en el sistema");
        }
        Cliente clienteRegistrado = clienteDAO.registrarCliente(cliente);
        System.out.println("clienteRegistrado = " + clienteRegistrado);
        return clienteRegistrado;
    }

    public Cliente buscarCliente(int idCliente) throws Exception {
        Cliente clienteBuscado = clienteDAO.buscarCliente(idCliente);
        System.out.println("clienteBuscado = " + clienteBuscado);
        return clienteBuscado;
    }

    public Cliente actualizarCliente(Cliente cliente, int idCliente) throws Exception {
        if (buscarCliente(idCliente).getIdCliente() == 0) {
            throw new RuntimeException("No se pudo actualizar el cliente porque no existe en el sistema");
        }
        Cliente clienteActualizado = clienteDAO.actualizarCliente(cliente, idCliente);
        System.out.println("clienteActualizado = " + clienteActualizado);
        return clienteActualizado;
    }

    public void eliminarCliente(int idCliente) throws Exception {
        if (buscarCliente(idCliente).getIdCliente() == 0) {
            throw new RuntimeException("No se pudo eliminar el cliente porque no existe en el sistema");
        }
        clienteDAO.eliminarCliente(idCliente);
        System.out.println("Cliente eliminado con id = " + idCliente);
    }
}
