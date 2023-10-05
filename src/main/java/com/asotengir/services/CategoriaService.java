package com.asotengir.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.MarcaResponseDTO;
import com.asotengir.dao.RegistroCategoriaDTO;
import com.asotengir.dao.RegistroMarcaDTO;

public interface CategoriaService {

	
	ResponseEntity<?> insertar(RegistroCategoriaDTO datos);
	
	ResponseEntity<?> agregarMarca(RegistroMarcaDTO datos, Long categoriaID);
	
	
	ResponseEntity<?> listarMarcas(Long categoriaID);
	
	
	ResponseEntity<?> eliminarMarca(Long categoriaID, Long marcaID);
	
}
