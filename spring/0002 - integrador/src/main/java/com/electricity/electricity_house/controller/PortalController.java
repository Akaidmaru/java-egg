package com.electricity.electricity_house.controller;

import com.electricity.electricity_house.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registrousuario.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String password, @RequestParam String password2, ModelMap model) {
        try {
            usuarioService.createUsuario(nombre, apellido, email, password, password2);
            model.put("exito", "El usuario fue creado satisfactoriamente.");
            return "index.html";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            model.put("nombre", nombre);
            model.put("email", email);

            return "registrousuario.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo){
        if (error != null){
            modelo.put()
        }
    }
}
