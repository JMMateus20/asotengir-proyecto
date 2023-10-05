package com.asotengir.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asotengir.dao.ActualizarEmpresaDTO;
import com.asotengir.dao.EmpresaDTO;
import com.asotengir.dao.EmpresaProductoDTO;
import com.asotengir.dao.RegistroEmpresaDTO;
import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.services.EmpresaService;
import com.asotengir.services.ValidacionService;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ValidacionService validacionService;
	
	@RequestMapping(value = "empresas", method = RequestMethod.POST)
	public ResponseEntity<?> insertar(@Valid @RequestBody RegistroEmpresaDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return empresaService.insertar(datos);
	}
	
	@RequestMapping(value = "empresas", method = RequestMethod.GET)
	public ResponseEntity<List<EmpresaDTO>> listar(){
		return empresaService.jointable();
	}
	
	@RequestMapping(value = "empresas/productos", method = RequestMethod.PUT)
	public ResponseEntity<?> agregarProductos(@Valid @RequestBody EmpresaProductoDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return empresaService.agregarProducto(datos);
	}
	
	@RequestMapping(value = "empresas/{empresaID}", method = RequestMethod.PUT)
	public ResponseEntity<?> modificar(@RequestBody ActualizarEmpresaDTO datos, @PathVariable Long empresaID){
		return empresaService.actualizar(datos, empresaID);
	}
	
	

}
