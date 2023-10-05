package com.asotengir.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import com.asotengir.model.Usuario;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SecurityConfig {
  @Bean
  public AuditorAware<Usuario> auditorAware() {
    return new SpringSecurityAuditorAware();
  }
}
