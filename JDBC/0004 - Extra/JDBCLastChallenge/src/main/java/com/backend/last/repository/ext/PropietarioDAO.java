package main.java.com.backend.last.repository.ext;

import main.java.com.backend.last.entity.Propietarios;
import main.java.com.backend.last.repository.DAO;


public class PropietarioDAO extends DAO {

    public void registrarPropietario(Propietarios propietario) throws Exception{
        String sql = "INSERT INTO propietarios (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, propietario.getNombre());
            preparedStatement.setString(2, propietario.getApellido());
            preparedStatement.setString(3, propietario.getEmail());
            preparedStatement.setString(4, propietario.getTelefono());
            preparedStatement.executeUpdate();
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectarDataBase();
        }
    }

    public void buscarPropietario(Propietarios propietario) throws Exception {
        String sql = "SELECT * FROM propietarios WHERE nombre = ? AND apellido = ? AND email = ? AND telefono = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, propietario.getNombre());
            preparedStatement.setString(2, propietario.getApellido());
            preparedStatement.setString(3, propietario.getEmail());
            preparedStatement.setString(4, propietario.getTelefono());
            preparedStatement.executeQuery();
            consultarDataBase(sql);
        } catch (Exception e) {
            e.printStackTrace();
    }


}
