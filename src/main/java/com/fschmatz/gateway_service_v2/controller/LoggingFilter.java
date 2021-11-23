package com.fschmatz.gateway_service_v2.controller;

import com.fschmatz.gateway_service_v2.entity.Gateway;
import com.fschmatz.gateway_service_v2.repository.GatewayRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

@Component
public class LoggingFilter implements GlobalFilter {

    Log log = LogFactory.getLog(getClass());


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Set<URI> uris = exchange.getAttributeOrDefault(GATEWAY_ORIGINAL_REQUEST_URL_ATTR, Collections.emptySet());
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        //Terminal
        log.info("\n\n--> SERVIÇO : " + route.getId()  + " \n--> URI : " + routeUri+"\n");
        //new Gateway().setLog('1');

        /*new GatewayRepository repository;
        repository.save(new Gateway());*/
        //saveLogs("Serviço : " + route.getId()  + " Uri : " + routeUri);



        return chain.filter(exchange);
    }
}