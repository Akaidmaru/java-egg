package persistencia;

import java.sql.*;

public abstract class DAO {
    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "root";
    private final String PASSWORD = "R3d$m4ro0.";
    private final String DATABASE = "vivero";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void insertarModificarEliminarDataBase(String sqlQuery) throws SQLException, ClassNotFoundException {
        try {
            conectarDataBase(); // Conecta
            statement = conexion.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            desconectarDataBase(); // Desconecta
        }
    }

    protected ResultSet consultarDataBase(String sqlQuery) throws SQLException, ClassNotFoundException {
        try {
            conectarDataBase(); // Conecta
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}