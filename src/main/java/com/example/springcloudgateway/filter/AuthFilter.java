package com.example.springcloudgateway.filter;

import com.example.springcloudgateway.jwt.JwtUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public AuthFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            ServerHttpRequest req = exchange.getRequest();
            ServerHttpResponse res = exchange.getResponse();

            log.info("Global Filter baseMessage:: {}", config.getBaseMessage());
            log.info("Global Filter Start:: Authoriztion -> {}", req.getHeaders().get("Authorization"));
//            Authorization 받아오기
            List<String> authorization = req.getHeaders().get("Authorization");
            if(authorization == null)
                return handleUnAuthorized(exchange);

            String accessToken = Objects.requireNonNull(authorization).get(0);
            //토큰 검증
            boolean valid = jwtUtil.isValidToken(accessToken);
            log.info("Global Filter valid:: valid -> {}", valid);
            if(!valid){
                log.info("Global Filter exception");
                return handleUnAuthorized(exchange);
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Global Filter End:: response code -> {}", res.getStatusCode());
            }));
        }));
    }

    private Mono<Void> handleUnAuthorized(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
