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

import com.asotengir.dao.RegistroComentariosDTO;
import com.asotengir.services.EmpresaProductoService;
import com.asotengir.services.ValidacionService;

@RestController
public class EmpresaProductoController {

	@Autowired
	private EmpresaProductoService epService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "productoEmpresa/{empresaProductoID}", method = RequestMethod.PUT)
	public ResponseEntity<?> agregarComentarios(@PathVariable Long empresaProductoID, @Valid @RequestBody RegistroComentariosDTO dato, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return epService.agregarComentarios(empresaProductoID, dato);
	}
	
	@RequestMapping(value = "productoEmpresa")
	public ResponseEntity<?> listarPorEmpresa(@RequestParam(name = "empresa", required = true) String nomEmpresa){
		return epService.listarPorEmpresa(nomEmpresa);
	}
	
	@RequestMapping(value = "productoEmpresa/location")
	public ResponseEntity<?> listarPorLocacion(@RequestParam(name = "pais", required = false) String nomPais, @RequestParam(name = "estado", required = false) String nomEstado, @RequestParam(name = "ciudad", required = false) String nomCiudad){
		return epService.listarPorLocacion(nomPais, nomEstado, nomCiudad);
	}
	
	@RequestMapping(value = "productoEmpresa/{usuarioID}")
	public ResponseEntity<?> listarProductoPorEmpresaDeUsuario(@PathVariable Long usuarioID){
		return epService.listarProductosDeEmpresasDeUsuario(usuarioID);
	}
}
