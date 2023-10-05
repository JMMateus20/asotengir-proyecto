package com.asotengir.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asotengir.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	
	
	Optional<Pais> findByNomPais(String nomPais);
	
}
