package com.example.tarea4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/admin")
    public String mostrarPaginaAdmin() {
        return "admin"; // Thymeleaf buscará el archivo admin.html en /templates
    }
}