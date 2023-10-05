package com.asotengir.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.dao.TipoEmpresaDTO;
import com.asotengir.services.TipoEmpresaService;
import com.asotengir.services.ValidacionService;

@RestController
public class TipoEmpresaController {
	
	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "tipos", method = RequestMethod.POST)
	ResponseEntity<?> insertar(@Valid @RequestBody RegistroTipoDTO tipo, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return tipoEmpresaService.insertar(tipo);
	}
	

}
