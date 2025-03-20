package com.electricity.electricity_house.controller;

import com.electricity.electricity_house.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("articulos", articuloService.listarArticulos());
        return "listaarticulo.html";
    }
}
