package ru.otus.hw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.otus.hw.dto.Email;
import ru.otus.hw.repositories.EmailRepository;
import ru.otus.hw.service.EmailService;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class FunctionalEndpointConfig {
    @Bean
    public RouterFunction<ServerResponse> composedRoutes(
            EmailService emailService
    ) {
        return route()
                .GET("/api/emails/{user_name}",
                        request -> ok().contentType(APPLICATION_JSON)
                                .body(emailService.findEmailsByUserName(request.pathVariable("user_name")), Email.class))
                .build();
    }
}