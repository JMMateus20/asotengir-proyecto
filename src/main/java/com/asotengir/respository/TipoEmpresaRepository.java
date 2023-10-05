package com.asotengir.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asotengir.model.TipoEmpresa;

public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa, Long>{
	
	Optional<TipoEmpresa> findByTipo(String tipo);
	
	

	

}
