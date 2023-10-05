package com.asotengir.services;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.dao.TipoEmpresaDTO;

public interface TipoEmpresaService{
	
	
	ResponseEntity<?> insertar(RegistroTipoDTO nombre);
	
}
	

	