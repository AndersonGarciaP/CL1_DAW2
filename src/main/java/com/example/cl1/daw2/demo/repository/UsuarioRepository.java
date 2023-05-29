package com.example.cl1.daw2.demo.repository;

import com.example.cl1.daw2.demo.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);

}
