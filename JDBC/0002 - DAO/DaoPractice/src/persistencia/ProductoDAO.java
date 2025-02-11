package persistencia;

import java.sql.PreparedStatement;

public class ProductoDAO extends DAO {

    public void eliminarProductoPorCodigo(int idProducto) throws Exception {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try {
            conectarDataBase();
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idProducto);
                preparedStatement.executeUpdate();
                System.out.println("Producto eliminado: " + idProducto);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
            throw new Exception(e);
        } finally {
            desconectarDataBase();
        }
    }
}
