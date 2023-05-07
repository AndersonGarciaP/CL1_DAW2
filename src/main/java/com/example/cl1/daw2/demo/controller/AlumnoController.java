package com.example.cl1.daw2.demo.controller;

import com.example.cl1.daw2.demo.model.bd.Alumno;
import com.example.cl1.daw2.demo.model.bd.Especialidad;
import com.example.cl1.daw2.demo.model.request.AlumnoRequest;
import com.example.cl1.daw2.demo.model.response.ResultadoResponse;
import com.example.cl1.daw2.demo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/formCrudAlumno")
    public String formCrudAlumno(Model model){
        model.addAttribute("listaAlumnos",
                alumnoService.listarAlumnos());
        return "Alumno/formCrudAlumno";
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody
                                           AlumnoRequest alumnoRequest){
        String mensaje = "Alumno registrado correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();
//            if(alumnoRequest.getIdalumno() > 0){
//                objAlumno.setIdalumno(alumnoRequest.getIdalumno());
//            }
            objAlumno.setIdalumno(alumnoRequest.getIdalumno());
            objAlumno.setNomalumno(alumnoRequest.getNomalumno());
            objAlumno.setApealumno(alumnoRequest.getApealumno());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdesp(alumnoRequest.getIdesp());
            objAlumno.setEspecialidad(objEspecialidad);
            objAlumno.setProce(alumnoRequest.getProce());

            alumnoService.registrarAlumno(objAlumno);
        }catch (Exception ex){
            mensaje = "Alumno no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody
                                          AlumnoRequest alumnoRequest){
        String mensaje = "Alumno eliminada correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "Alumno no eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }


}
