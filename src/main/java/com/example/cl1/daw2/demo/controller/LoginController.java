package com.example.cl1.daw2.demo.controller;


import com.example.cl1.daw2.demo.model.bd.Usuario;
import com.example.cl1.daw2.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(){
        return "Auth/frmLogin";
    }
    @GetMapping("/registrar")
    public String registrar(){
        return "Auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "Auth/frmLogin";
    }

}
