/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class indexController {

    @RequestMapping("/") // nombre del URL ruta que responde a esta peticion
    public String index(Model model) {
        model.addAttribute("NombreProfesor", "Jonathan");
        return "index"; // nombre de la vista de template que se desea mostrar
    }

    @RequestMapping("/info")
    public String info() {
        return "info"; // 
    }

}
