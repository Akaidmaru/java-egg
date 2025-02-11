package main.java.com.backend.estancias.repository.ext;

import main.java.com.backend.estancias.entity.Familia;
import main.java.com.backend.estancias.repository.DAO;

import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

    public Familia registrarFamilia(Familia familia) throws Exception {

        String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email,id_casa_familia )" +
                " VALUES(" +
                "'" + familia.getNombre() + "'," +
                "'" + familia.getEdadMinima() + "'," +
                "'" + familia.getEdadMaxima() + "'," +
                "'" + familia.getNumHijos() + "'," +
                "'" + familia.getEmail() + "'," +
                "'" + familia.getIdCasaFamilia() + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Familia> familiasRegistradas = listarFamilias();
        return buscarFamilia(familiasRegistradas.get(familiasRegistradas.size() - 1).getIdFamilia());
    }


    public List<Familia> listarFamilias() throws Exception {

        String sql = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email,id_casa_familia FROM familias";
        consultarDataBase(sql);

        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            Familia familia = new Familia();
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getNString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getNString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

            familias.add(familia);
        }

        desconectarDataBase();
        return familias;
    }

    public List<Familia> listarFamiliasNumHijosAndEdadMaxima() throws Exception {
        String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
        consultarDataBase(sql);

        List<Familia> familias = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getNString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getNString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

                familias.add(familia);
            }
        } finally {
            desconectarDataBase();
        }
        return familias;
    }


    public List<Familia> listarFamiliasEmailHotmail() throws Exception {
        String sql = "SELECT * FROM familias WHERE email LIKE '%@hotmail.%'";
        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setIdFamilia(resultSet.getInt("id_familia"));
                familia.setNombre(resultSet.getNString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getNString("email"));
                familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

                familias.add(familia);
            }
        } finally {
            desconectarDataBase();
        }
        return familias;
    }

    public Familia buscarFamilia(int idFamilia) throws Exception {
        String sql = "SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email,id_casa_familia FROM familias WHERE id_familia=" + idFamilia;
        consultarDataBase(sql);

        Familia familia = new Familia();
        while (resultSet.next()) {
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getNString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getNString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        }

        desconectarDataBase();
        return familia;
    }

    public boolean buscarFamiliaByName(String nameFamily) throws Exception {
        String sql = " SELECT id_familia, nombre, edad_minima, edad_maxima, num_hijos, email,id_casa_familia FROM familias WHERE nombre = " + "'" + nameFamily + "'";
        consultarDataBase(sql);

        Familia familia = new Familia();
        while (resultSet.next()) {
            familia.setIdFamilia(resultSet.getInt("id_familia"));
            familia.setNombre(resultSet.getString("nombre"));
            familia.setEdadMinima(resultSet.getInt("edad_minima"));
            familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
            familia.setNumHijos(resultSet.getInt("num_hijos"));
            familia.setEmail(resultSet.getNString("email"));
            familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        }

        desconectarDataBase();
        if (familia.getNombre() != null) {
            return familia.getNombre().equals(nameFamily);
        }
        return false;

    }

    public Familia actualizarFamilia(Familia familia, int idFamilia) throws Exception {

        String sql = "UPDATE familias SET nombre=?, edad_minima=?, edad_maxima=?, num_hijos=?, email=?, id_casa_familia=? WHERE id_familia=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        System.out.println("FamiliaAActualizar = " + familia);
        preparedStatement.setString(1, familia.getNombre());
        preparedStatement.setInt(2, familia.getEdadMinima());
        preparedStatement.setInt(3, familia.getEdadMaxima());
        preparedStatement.setInt(4, familia.getNumHijos());
        preparedStatement.setString(5, familia.getEmail());
        preparedStatement.setInt(6, familia.getIdCasaFamilia());
        preparedStatement.setInt(7, idFamilia);

        preparedStatement.executeUpdate();
        //List<Familia> familiasRistradas = listarFamilias();
        return buscarFamilia(idFamilia);
    }


    public void eliminarFamilia(int idFamilia) throws Exception {
        String sql = "DELETE from familias WHERE id_familia=" + idFamilia;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }

}
