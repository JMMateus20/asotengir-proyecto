package com.asotengir.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asotengir.dao.RegistroCiudadDTO;
import com.asotengir.services.EstadoService;
import com.asotengir.services.ValidacionService;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "estados/ciudades/{estadoID}", method = RequestMethod.PUT)
	public ResponseEntity<?> agregarCiudad(@Valid @RequestBody RegistroCiudadDTO datos, @PathVariable Long estadoID, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return estadoService.agregarCiudad(datos, estadoID);
	}
	
	
	@RequestMapping(value = "estados/{estadoID}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long estadoID){
		return estadoService.buscar(estadoID);
	}
	
	@RequestMapping(value = "estados/ciudades/{estadoID}")
	public ResponseEntity<?> listarCiudades(@PathVariable Long estadoID, @PageableDefault(page = 0, size = 10, sort = "nomCiudad") Pageable page){
		return estadoService.listarCiudades(estadoID, page);
	}

}
