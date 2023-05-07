package com.example.cl1.daw2.demo.service;

import com.example.cl1.daw2.demo.model.bd.Especialidad;
import com.example.cl1.daw2.demo.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades(){
        return especialidadRepository.findAll();
    }

    public void registrarEspecialidad(Especialidad especialidad){
        especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(Especialidad especialidad){
        especialidadRepository.deleteById(especialidad.getIdesp());
    }

}
