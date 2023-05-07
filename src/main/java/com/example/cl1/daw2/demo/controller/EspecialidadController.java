package com.example.cl1.daw2.demo.controller;

import com.example.cl1.daw2.demo.model.bd.Especialidad;
import com.example.cl1.daw2.demo.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/formEspecialidad")
    public String formEspecialidad(Model model){
        model.addAttribute("listaEspecialidades", especialidadService.listarEspecialidades());
        return "Especialidad/formEspecialidad";
    }

    @GetMapping("/listarEspecialidades")
    @ResponseBody
    public List<Especialidad> listarEspecialidades(){
        return especialidadService.listarEspecialidades();
    }

}
