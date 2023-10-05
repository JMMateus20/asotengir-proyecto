package com.asotengir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asotengir.dao.ActualizarCategoriaDeMarcaDTO;
import com.asotengir.dao.ActualizarNombreDeMarcaDTO;
import com.asotengir.services.MarcaService;

@RestController
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value = "marcas/cat/{marcaID}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarCategoria(@RequestBody ActualizarCategoriaDeMarcaDTO datos, @PathVariable Long marcaID){
		return marcaService.actualizarCategoria(datos, marcaID);
	}
	
	@RequestMapping(value = "marcas/name/{marcaID}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarNombre(@RequestBody ActualizarNombreDeMarcaDTO datos, @PathVariable Long marcaID){
		return marcaService.actualizarNombre(datos, marcaID);
	}

}
