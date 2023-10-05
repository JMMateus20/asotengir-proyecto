package com.asotengir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asotengir.dao.EstadoCiudadDTO;
import com.asotengir.services.CiudadService;

@RestController
public class CiudadController {
	
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value = "ciudades/estados")
	public ResponseEntity<List<EstadoCiudadDTO>> listar(){
		return ciudadService.listarCiudades();
	}
	
	@RequestMapping(value = "ciudades")
	public ResponseEntity<?> buscarPorNombre(@RequestParam(name = "nombre", required = true) String nomCiudad){
		return ciudadService.buscarPorNombre(nomCiudad);
	}

}
