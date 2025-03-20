package com.electricity.electricity_house.controller;

import com.electricity.electricity_house.entities.Fabrica;
import com.electricity.electricity_house.services.FabricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fabrica")
public class FabricaController {

    @Autowired
    private FabricaService fabricaService;

    @GetMapping("/lista")
    public String listar(ModelMap modelo){
        try {
            List<Fabrica> fabricas = fabricaService.listarFabricas();
            modelo.addAttribute("fabricas", fabricas);
            return "listafabrica.html";
        } catch (Exception e){
            modelo.addAttribute("error", "Ocuirró eun error al cargar la lista de fábricas.");
            return "error.html";
        }
    }


}
