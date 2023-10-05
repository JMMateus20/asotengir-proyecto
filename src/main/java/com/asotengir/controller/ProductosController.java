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

import com.asotengir.dao.ActualizarProductoDTO;
import com.asotengir.dao.ProductoDTO;
import com.asotengir.dao.RegistroProductoDTO;
import com.asotengir.services.ProductoService;
import com.asotengir.services.ValidacionService;

@RestController
public class ProductosController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ValidacionService validacionService;
	
	
	@RequestMapping(value = "productos", method = RequestMethod.POST)
	public ResponseEntity<?> insertar(@Valid @RequestBody RegistroProductoDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return productoService.insertar(datos);
	}
	
	
	@RequestMapping(value = "productos")
	public ResponseEntity<?> listarJoin(){
		List<ProductoDTO> response=productoService.listarJoin();
		if (response.isEmpty()) {
			return new ResponseEntity<>("No hay nada en la lista por el momento", HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "productos/{idProducto}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizar(@PathVariable Long idProducto, @Valid @RequestBody ActualizarProductoDTO datos, BindingResult resultado){
		if (resultado.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validacionService.formatarMensaje(resultado));
		}
		return productoService.modificar(idProducto, datos);
	}
	
	

}
