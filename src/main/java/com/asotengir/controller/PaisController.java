package com.asotengir.controller;

import java.util.List;

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

import com.asotengir.dao.RegistroEstadoDTO;
import com.asotengir.dao.RegistroPaisDTO;
import com.asotengir.model.Pais;
import com.asotengir.services.PaisService;
import com.asotengir.services.ValidacionService;

@RestController
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private ValidacionService validacionService;
	
	
	@RequestMapping(value = "paises", method = RequestMethod.POST)
	public ResponseEntity<?> insertar(@Valid @RequestBody RegistroPaisDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return paisService.registrar(datos);
	}
	
	@RequestMapping(value = "paises/estados/{paisID}", method = RequestMethod.PUT)
	public ResponseEntity<?> agregarEstado(@Valid @RequestBody RegistroEstadoDTO datos, @PathVariable Long paisID, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return paisService.agregarEstado(datos, paisID );
	}
	
	@RequestMapping(value = "paises/{idPais}")
	public ResponseEntity<?> buscarPorNombre(@PathVariable Long idPais){
		return paisService.buscar(idPais);
	}
	
	@RequestMapping(value = "paises/estados/{idPais}")
	public ResponseEntity<?> encontrarEstados(@PathVariable Long idPais){
		return paisService.buscarEstados(idPais);
	}
	
	@RequestMapping(value = "paises")
	public ResponseEntity<List<Pais>> listar(){
		return paisService.listar();
	}

}
