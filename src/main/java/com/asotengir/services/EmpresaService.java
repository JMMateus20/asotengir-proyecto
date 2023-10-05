package com.asotengir.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.ActualizarEmpresaDTO;
import com.asotengir.dao.EmpresaDTO;
import com.asotengir.dao.EmpresaProductoDTO;
import com.asotengir.dao.RegistroEmpresaDTO;
import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.model.TipoEmpresa;

public interface EmpresaService {

	ResponseEntity<?> insertar(RegistroEmpresaDTO datos);
	
	
	ResponseEntity<List<EmpresaDTO>> jointable();
	
	
	ResponseEntity<?> agregarProducto(EmpresaProductoDTO datos);
	
	
	ResponseEntity<?> actualizar(ActualizarEmpresaDTO datos, Long empresaID);
	
	
	
}
