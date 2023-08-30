package com.org.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.io.ObjectInputFilter;
@Component
public class CustomFilter extends AbstractGatewayFilterFactory {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public GatewayFilter apply(Object config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                logger.info("This is custom Pre-filter: Request sent on "+ exchange.getRequest().getPath());
                return chain.filter(exchange).then(
                        Mono.fromRunnable(()->{
                            logger.info("This is  custom Post-filter: "+ exchange.getResponse().getStatusCode());
                        })
                );
            }
        };
    }

}
