package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;
    private EditorialService editorialService;

    @GetMapping("/registrar")
    public String registrar(ModelMap model){
        List<Autor> autores = autorService.listAutores();
        List<Editorial> editoriales = editorialService.listEditoriales();
        model.addAttribute("autores", autores);
        model.addAttribute("editoriales", editoriales);
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre){
        try{
            autorService.createAutor(nombre);
        } catch (Exception ex) {
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            return "autor_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        List<Autor> autores = autorService.listAutores();
        modelo.addAttribute("autores", autores);
        return "autor_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo){
        modelo.put("autor", autorService.getOne(id));

        return "autor_modificar.html";
    }

    @PostMapping("{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo){
        try{
            autorService.modifi
        }
    }

}
