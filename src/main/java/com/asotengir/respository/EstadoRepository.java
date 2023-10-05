package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asotengir.model.Estado;
import com.asotengir.model.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Optional<Estado> findByNomEstado(String nombre);
	
	
	Page<Estado> findByPais(Pais pais, Pageable page);
}
