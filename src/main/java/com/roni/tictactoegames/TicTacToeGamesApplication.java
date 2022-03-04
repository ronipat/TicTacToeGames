package com.roni.tictactoegames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class TicTacToeGamesApplication extends SpringBootServletInitializer {

    public void run(String... args) throws Exception {
        logger.info("Application starts ...");
    }

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeGamesApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TicTacToeGamesApplication.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @PreDestroy
    public void destroy() {
        logger.info("Application ends ...");
    }
}
