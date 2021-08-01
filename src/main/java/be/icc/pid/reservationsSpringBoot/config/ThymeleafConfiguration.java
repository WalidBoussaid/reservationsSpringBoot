package be.icc.pid.reservationsSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfiguration {
    @Bean
    public LayoutDialect thymeleafDialect() {
        return new LayoutDialect();
    }
}

