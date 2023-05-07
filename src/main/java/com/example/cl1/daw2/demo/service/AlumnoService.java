package com.example.cl1.daw2.demo.service;

import com.example.cl1.daw2.demo.model.bd.Alumno;
import com.example.cl1.daw2.demo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }
    public void registrarAlumno(Alumno alumno){
        alumnoRepository.save(alumno);
    }
    public void eliminarAlumno(String idalumno){
        alumnoRepository.deleteById(idalumno);
    }
}
