package main.java.com.backend.estancias.service;

import main.java.com.backend.estancias.entity.Comentario;
import main.java.com.backend.estancias.repository.ext.ComentarioDAO;

import java.util.List;

public class ComentarioService {
    private ComentarioDAO comentarioDAO;

    public ComentarioService() {
        this.comentarioDAO = new ComentarioDAO();
    }

    public List<Comentario> listarComentarios() throws Exception {
        List<Comentario> comentarios = comentarioDAO.listarComentarios();
        for (Comentario comentario : comentarios) {
            System.out.println("comentario = " + comentario);
        }
        return comentarios;
    }

    public Comentario registrarComentario(Comentario comentario) throws Exception {
        Comentario comentarioRegistrado = comentarioDAO.registrarComentario(comentario);
        System.out.println("comentarioRegistrado = " + comentarioRegistrado);
        return comentarioRegistrado;
    }

    public Comentario buscarComentario(int idComentario) throws Exception {
        Comentario comentarioBuscado = comentarioDAO.buscarComentario(idComentario);
        System.out.println("comentarioBuscado = " + comentarioBuscado);
        return comentarioBuscado;
    }

    public Comentario actualizarComentario(Comentario comentario, int idComentario) throws Exception {
        if (buscarComentario(idComentario).getIdComentario() == 0) {
            throw new RuntimeException("No se pudo actualizar el comentario porque no existe en el sistema");
        }
        Comentario comentarioActualizado = comentarioDAO.actualizarComentario(comentario, idComentario);
        System.out.println("comentarioActualizado = " + comentarioActualizado);
        return comentarioActualizado;
    }

    public void eliminarComentario(int idComentario) throws Exception {
        if (buscarComentario(idComentario).getIdComentario() == 0) {
            throw new RuntimeException("No se pudo eliminar el comentario porque no existe en el sistema");
        }
        comentarioDAO.eliminarComentario(idComentario);
        System.out.println("Comentario eliminado con id = " + idComentario);
    }
}
