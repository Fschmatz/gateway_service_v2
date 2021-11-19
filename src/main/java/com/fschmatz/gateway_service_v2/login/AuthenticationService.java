package com.fschmatz.gateway_service_v2.login;

import com.fschmatz.gateway_service_v2.entity.Usuario;
import com.fschmatz.gateway_service_v2.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException("Invalido");
        }

        return usuario.get();
    }

}
