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

import com.asotengir.dao.RegistroUsuarioDTO;
import com.asotengir.services.UsuarioService;
import com.asotengir.services.ValidacionService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "usuarios", method = RequestMethod.POST)
	public ResponseEntity<?> insertar(@Valid @RequestBody RegistroUsuarioDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return usuarioService.insertar(datos);
	}

}
