package main.java.com.backend.estancias.repository;

import java.sql.*;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "xxxx";
    private final String PASSWORD = "xxxx";
    private final String DATABASE = "xxxxxxxx";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    protected void connectarDataBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void desconectarDataBase() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conexion != null) {
                conexion.close();
                System.out.println("Cerrando conexion DDBB");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void insertarModificarEliminarDataBase(String sql) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA, USER, PASSWORD);
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Dato OK en BBDD");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    protected void consultarDataBase(String sql) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA, USER, PASSWORD);
            Statement stmt = conn.createStatement()) {
            resultSet = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    protected void prepareStatementInsertarModificarEliminarDataBase(String sql) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            preparedStatement = pstmt;
            System.out.println("Dato OK en BBDD");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
