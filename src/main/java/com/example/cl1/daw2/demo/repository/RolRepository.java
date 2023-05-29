package com.example.cl1.daw2.demo.repository;

import com.example.cl1.daw2.demo.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>
{
    Rol findByNomrol(String nomrol);
}
