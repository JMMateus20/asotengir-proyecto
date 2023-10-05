package com.asotengir.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.asotengir.dao.RegistroEstadoDTO;
import com.asotengir.dao.RegistroPaisDTO;
import com.asotengir.model.Pais;

public interface PaisService {

	ResponseEntity<?> registrar(RegistroPaisDTO datos);
	
	
	ResponseEntity<?> agregarEstado(RegistroEstadoDTO datos, Long paisID);
	
	
	
	ResponseEntity<?> buscar(Long idPais);
	
	
	ResponseEntity<?> buscarEstados(Long idPais);
	
	
	ResponseEntity<List<Pais>> listar();
}
