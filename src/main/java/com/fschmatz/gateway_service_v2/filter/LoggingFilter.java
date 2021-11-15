package com.fschmatz.gateway_service_v2.filter;

import com.fschmatz.gateway_service_v2.entity.Gateway;
import com.fschmatz.gateway_service_v2.repository.GatewayRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

@Component //necessario?
public class LoggingFilter implements GlobalFilter {
    Log log = LogFactory.getLog(getClass());
    GatewayRepository repository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Set<URI> uris = exchange.getAttributeOrDefault(GATEWAY_ORIGINAL_REQUEST_URL_ATTR, Collections.emptySet());

        String originalUri = (uris.isEmpty()) ? exchange.getRequest().getURI().toString() : uris.iterator().next().toString();
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        //log Terminal
        log.info("Request " + originalUri + " para o serviço: " + route.getId());


        //log save
        String logText = "Request " + originalUri + " para o serviço: " + route.getId();
        Gateway gatewaylog = new Gateway();
        gatewaylog.setLog(logText);
        System.out.println("Texto do log pro db ---> "+log.toString());
        repository.save(gatewaylog);

        return chain.filter(exchange);
    }
}