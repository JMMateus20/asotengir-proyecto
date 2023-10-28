package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asotengir.dao.EstadoPais;
import com.asotengir.model.Estado;
import com.asotengir.model.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Optional<Estado> findByNomEstado(String nombre);
	
	
	List<Estado> findByPais(Pais pais);
	
	@Query("SELECT new com.asotengir.dao.EstadoPais(p.nomPais, e.nomEstado, p.idPais, e.idEstado) "
			+ " FROM Estado e LEFT JOIN e.pais p ORDER BY e.nomEstado DESC") 
	List<EstadoPais> listarEstados();
}
