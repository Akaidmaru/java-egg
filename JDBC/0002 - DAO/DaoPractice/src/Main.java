import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.ProductoDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        ClienteDAO clienteDao = new ClienteDAO();
        System.out.println(clienteDao.listarTodosLosClientes().toString());
        // clientedao.guardarCliente(new Cliente("Pedro", "Perez", "+56948586969"));
        Cliente clienteCodigo = clienteDao.buscarClientePorCodigo(3);
        System.out.println("Cliente encontrado: " + clienteCodigo.toString());

        
        ProductoDAO productoDAO = new ProductoDAO();
        int idProducto = 1;
        productoDAO.eliminarProductoPorCodigo(idProducto);
    }
}
