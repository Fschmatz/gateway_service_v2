package com.fschmatz.gateway_service_v2.repository;


import com.fschmatz.gateway_service_v2.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface GatewayRepository extends JpaRepository<Gateway, Integer> {
    public Optional<Gateway> findByLogin(String login);
}
