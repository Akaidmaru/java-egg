package com.electricity.electricity_house.services;

import com.electricity.electricity_house.entities.Usuario;
import com.electricity.electricity_house.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public void createUsuario(String nombre, String apellido, String email, String password, String password2) throws Exception {
        validate(nombre, apellido, email, password, password2);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        
        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario getOne(UUID usuarioId){
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    @Transactional(readOnly = true)
    public Usuario findByName(String name){
        return usuarioRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Usuario findByLastName(String lastName){
        return usuarioRepository.findByLastName(lastName);
    }

    @Transactional(readOnly = true)
    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    @Transactional
    public void modifyUsuario(UUID idUsuario, String email, String nombre, String apellido, String password) throws Exception {
        Optional<Usuario> response = usuarioRepository.findById(idUsuario);

        if(response.isEmpty()){
            throw new Exception("El Usuario que buscas no existe.");
        }

        Usuario usuario = response.get();
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPassword(password);

        usuarioRepository.save(usuario);
    }
    
    public void validate(String nombre, String apellido, String email, String password, String password2) throws Exception {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El Nombre no puede ser nulo o estar vacío.");
        }
        if(apellido == null || apellido.trim().isEmpty()){
            throw new Exception("El Apellido no puede ser nulo o estar vacío.");
        }
        if(email == null || email.trim().isEmpty()){
            throw new Exception("El Correo electrónico no puede ser nulo o estar vacío.");
        }
        if(!password.equals(password2)){
            throw new Exception("La contraseñas deben ser iguales.");
        }
    }
}
