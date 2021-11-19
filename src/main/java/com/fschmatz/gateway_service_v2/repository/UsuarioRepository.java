package com.fschmatz.gateway_service_v2.repository;

import com.fschmatz.gateway_service_v2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByLogin(String login);
}
