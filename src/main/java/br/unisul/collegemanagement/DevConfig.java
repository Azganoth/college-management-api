package br.unisul.collegemanagement;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring.jpa.hibernate", name = "ddl-auto", havingValue = "create")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DevConfig {

    @Bean
    public void letTheDataFlow() {
    }

}
