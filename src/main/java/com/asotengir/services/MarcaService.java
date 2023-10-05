package com.asotengir.services;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.ActualizarCategoriaDeMarcaDTO;
import com.asotengir.dao.ActualizarNombreDeMarcaDTO;


public interface MarcaService {

	ResponseEntity<?> actualizarCategoria(ActualizarCategoriaDeMarcaDTO datos, Long marcaID);
	
	
	ResponseEntity<?> actualizarNombre(ActualizarNombreDeMarcaDTO datos, Long marcaID);
	
	
	
	

}
