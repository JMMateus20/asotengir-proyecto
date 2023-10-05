package com.asotengir.services;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.asotengir.dao.RegistroCiudadDTO;
import com.asotengir.dao.RegistroEstadoDTO;

public interface EstadoService {

	ResponseEntity<?> agregarCiudad(RegistroCiudadDTO datos, Long estadoID);
	
	
	ResponseEntity<?> buscar(Long idEstado);
	
	
	ResponseEntity<?> listarCiudades(Long idEstado, Pageable page);
}
