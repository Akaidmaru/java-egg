import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();
        System.out.println("------------------------------QUERY 1---------------------------------------------");
        buscarClientes(conexion);
        System.out.println("------------------------------QUERY 2---------------------------------------------");
        getProductosParaReponer(conexion, 20);
        System.out.println("------------------------------QUERY 3---------------------------------------------");
        getProductosGama(conexion, "Herramientas");
        cerrarConexion(conexion);


    }

    public static Connection getConnection() {
        String host = "127.0.0.1";
        String port = "3306"; // Puerto por defecto para MySQL
        String name = "root"; // usuario de la base de datos
        String password = "R3d$m4ro0."; // password de la base de datos
        String database = "vivero"; // nombre de la base de datos recien creada, en este caso vivero.
        // Esto especifica una zona horaria, no es obligatorio de utilizar, pero en
        // algunas zonas genera conflictos de conexión si no existiera
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
        // esto indica la ruta de conexion, que es la combinacion de
        // host,usuario,puerto, nombre de la base de datos a la cual queremos
        // conectarnos y la zona horaria (si se precisara).


        Connection conexion = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            conexion = DriverManager.getConnection(url, name, password);
            System.out.println("Conexión exitosa a la base de datos.");


            // Statement
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_cliente, nombre_cliente, limite_credito FROM cliente");
                while (rs.next()) {
                    int x = rs.getInt("id_cliente");
                    String s = rs.getString("nombre_cliente");
                    double d = rs.getDouble("limite_credito");
                    System.out.println("Fila = " + x + " " + s + " " + d);
                }


            } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el conector JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;



    }


    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión:" + e.getMessage());
            }
        }
    }

    public static void buscarClientes(Connection connection){
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente";
        try(Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql))   {
            int count = 0;
            while(rs.next()){
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " ) " + "Nombre: " + nombre + " Apellido: " + apellido + " Telefono: " + telefono);
            }
    } catch (SQLException e) {
        System.out.println("Error al buscar clientes: " + e.getMessage());
    }
}

    public static void getProductosParaReponer(Connection connection, int puntoReposicion){
        String sql = "SELECT id_producto, nombre, cantidad_en_stock FROM producto WHERE cantidad_en_stock < ?" ;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setInt(1, puntoReposicion);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad_en_stock");
                System.out.println("ID: " + id + " Nombre: " + nombre + " Cantidad en stock: " + cantidad);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar productos para reponer: " + e.getMessage());
        }
    }



        public static void getProductosGama(Connection connection, String nombre_gama){
            String sql = "SELECT p.id_producto, p.nombre, p.id_gama, g.gama FROM producto p, gama_producto g " +
                    "WHERE p.id_gama = g.id_gama AND gama=?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)){

                pstmt.setString(1, nombre_gama);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id_producto");
                    String nombre = rs.getString("nombre");
                    String gama = rs.getString("gama");
                    int id_gama = rs.getInt("id_gama");
                    System.out.println("ID: " + id + " Nombre: " + nombre + " Cantidad en stock: " + gama + " Gama" + id_gama);
                }

            } catch (SQLException e) {
                System.out.println("Error al buscar productos para reponer: " + e.getMessage());
            }
        }


    public static void getProductosPorGamaList(Connection connection) {
        String sql = "SELECT g.gama, COUNT(p.id_producto) AS cantidad FROM producto p, gama_producto g " +
                "WHERE p.id_gama = g.id_gama GROUP BY g.gama";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String gama = rs.getString("gama");
                int cantidad = rs.getInt("cantidad");
                System.out.println("Cantidad " + cantidad + " - Gama " + gama);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos por gama: " + e.getMessage());
        }
    }



    public static void getProductosNoComprados(Connection connection) {
        String sql = "SELECT p.id_producto, p.nombre FROM producto p " +
                "LEFT JOIN detalle_pedido dp ON p.id_producto = dp.id_producto " +
                "WHERE dp.id_producto IS NULL";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + " Nombre: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos no comprados: " + e.getMessage());
        }


        public static void getPedidosPorProducto(Connection connection, int id_producto){
            String sql = "SELECT p.id_producto, p.nombre, COUNT(dp.id_pedido) AS cantidad_pedidos FROM producto p " +
                    "LEFT JOIN detalle_pedido dp ON p.id_producto = dp.id_producto " +
                    "WHERE p.id_producto = ? GROUP BY p.id_producto";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, id_producto);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id_producto");
                    String nombre = rs.getString("nombre");
                    int cantidad = rs.getInt("cantidad_pedidos");
                    System.out.println("ESTO ES EL RS:-------------------------------");
                    System.out.println(rs);
                    System.out.println("ESTO ES EL FIN DEL RS:-------------------------------");
                    System.out.println("ID: " + id + " Nombre: " + nombre + " Cantidad de pedidos: " + cantidad);
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar pedidos por producto: " + e.getMessage());
        }
    }

        
}

