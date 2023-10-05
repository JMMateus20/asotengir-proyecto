package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.asotengir.dao.EstadoCiudadDTO;
import com.asotengir.model.Ciudad;
import com.asotengir.model.Estado;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
	
	
	@Query("SELECT new com.asotengir.dao.EstadoCiudadDTO(c.nomCiudad, c.idCiudad, e.nomEstado, e.idEstado, p.nomPais, p.idPais) "
			+ "FROM Ciudad c INNER JOIN c.estado e INNER JOIN c.estado.pais p ORDER BY c.nomCiudad ASC")
	List<EstadoCiudadDTO> listar();
	
	
	Optional<Ciudad> findByNomCiudad(String nomCiudad);

	List<Ciudad> findByEstado(Estado estado);
}
