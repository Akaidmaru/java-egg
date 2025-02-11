package main.java.com.backend.estancias.repository.ext;

import main.java.com.backend.estancias.entity.Comentario;
import main.java.com.backend.estancias.repository.DAO;

import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO {

    public Comentario registrarComentario(Comentario comentario) throws Exception {
        String sql = "INSERT INTO comentarios (id_casa, comentario) VALUES(" +
                "'" + comentario.getIdCasa() + "'," +
                "'" + comentario.getComentario() + "'" +
                ")";

        insertarModificarEliminarDataBase(sql);
        List<Comentario> comentariosRegistrados = listarComentarios();
        return buscarComentario(comentariosRegistrados.get(comentariosRegistrados.size() - 1).getIdComentario());
    }

    public List<Comentario> listarComentarios() throws Exception {
        String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios";
        consultarDataBase(sql);

        List<Comentario> comentarios = new ArrayList<>();
        while (resultSet.next()) {
            Comentario comentario = new Comentario();
            comentario.setIdComentario(resultSet.getInt("id_comentario"));
            comentario.setIdCasa(resultSet.getInt("id_casa"));
            comentario.setComentario(resultSet.getString("comentario"));

            comentarios.add(comentario);
        }

        desconectarDataBase();
        return comentarios;
    }

    public Comentario buscarComentario(int idComentario) throws Exception {
        String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios WHERE id_comentario=" + idComentario;
        consultarDataBase(sql);

        Comentario comentario = new Comentario();
        while (resultSet.next()) {
            comentario.setIdComentario(resultSet.getInt("id_comentario"));
            comentario.setIdCasa(resultSet.getInt("id_casa"));
            comentario.setComentario(resultSet.getString("comentario"));
        }

        desconectarDataBase();
        return comentario;
    }

    public Comentario actualizarComentario(Comentario comentario, int idComentario) throws Exception {
        String sql = "UPDATE comentarios SET id_casa=?, comentario=? WHERE id_comentario=?";
        prepareStatementInsertarModificarEliminarDataBase(sql);
        preparedStatement.setInt(1, comentario.getIdCasa());
        preparedStatement.setString(2, comentario.getComentario());
        preparedStatement.setInt(3, idComentario);

        preparedStatement.executeUpdate();
        return buscarComentario(idComentario);
    }

    public void eliminarComentario(int idComentario) throws Exception {
        String sql = "DELETE from comentarios WHERE id_comentario=" + idComentario;
        insertarModificarEliminarDataBase(sql);
        desconectarDataBase();
    }
}
