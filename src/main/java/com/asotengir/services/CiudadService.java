package com.asotengir.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.EstadoCiudadDTO;

public interface CiudadService {

	ResponseEntity<List<EstadoCiudadDTO>> listarCiudades();
	
	
	ResponseEntity<?> buscarPorId(Long idCiudad);
}
