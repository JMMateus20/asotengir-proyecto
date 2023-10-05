package com.asotengir.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.asotengir.dao.RegistroCategoriaDTO;
import com.asotengir.dao.RegistroMarcaDTO;
import com.asotengir.services.CategoriaService;
import com.asotengir.services.ValidacionService;

@RestController
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "categorias", method = RequestMethod.POST)
	public ResponseEntity<?> insertar(@Valid @RequestBody RegistroCategoriaDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return categoriaService.insertar(datos);
	}
	
	@RequestMapping(value = "categorias/marcas/{categoriaID}", method = RequestMethod.PUT)
	public ResponseEntity<?> agregarMarca(@Valid @RequestBody RegistroMarcaDTO datos, @PathVariable Long categoriaID, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return categoriaService.agregarMarca(datos, categoriaID);
	}
	
	@RequestMapping(value = "categorias/{categoriaID}")
	public ResponseEntity<?> listarMarcas(@PathVariable Long categoriaID){
		return categoriaService.listarMarcas(categoriaID);
	}
	
	@RequestMapping(value = "categorias/marcas/eliminar", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarMarca(@RequestParam(name = "categoriaID", required = true) Long categoriaID, @RequestParam(name = "marcaID", required = true) Long marcaID){
		return categoriaService.eliminarMarca(categoriaID, marcaID);
	}

}
