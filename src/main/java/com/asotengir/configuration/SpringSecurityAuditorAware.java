package com.asotengir.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.asotengir.model.Usuario;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<Usuario> {
  @Override
  public Optional<Usuario> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated()) {
    	System.out.println("no autenticado");
      return Optional.empty();
    }
    return Optional.of((Usuario) authentication.getPrincipal());
  }
}