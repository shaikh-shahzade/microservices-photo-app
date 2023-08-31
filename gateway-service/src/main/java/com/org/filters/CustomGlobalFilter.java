package com.org.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class CustomGlobalFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(CustomFilter.class);
    @Override
    @Order(0)
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("This is Global pre filter callled for: "+ exchange.getRequest().getURI() );
        return chain.filter(exchange).then(
                Mono.fromRunnable(
                ()->{
                    logger.info("This is Global post Filter : response code = " + exchange.getResponse().getStatusCode());

                })
        );
    }
}
