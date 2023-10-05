package com.asotengir.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.dao.TipoEmpresaDTO;
import com.asotengir.model.TipoEmpresa;
import com.asotengir.respository.TipoEmpresaRepository;

@Service
public class TipoEmpresaServiceImpl implements TipoEmpresaService{
	
	@Autowired
	private TipoEmpresaRepository tipoEmpresaRep;

	@Override
	public ResponseEntity<?> insertar(RegistroTipoDTO nombre) {
		Optional<TipoEmpresa> tipoYaExistente=tipoEmpresaRep.findByTipo(nombre.getTipo());
		if (tipoYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("este registro ya fue insertado");
		}
		TipoEmpresa tipoNuevo=new TipoEmpresa(nombre.getTipo());
		tipoEmpresaRep.save(tipoNuevo);
		return ResponseEntity.ok("insertado");
	}

	

}
