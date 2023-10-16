package com.asotengir.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.ActualizarProductoDTO;
import com.asotengir.dao.ProductoDTO;
import com.asotengir.dao.RegistroProductoDTO;

public interface ProductoService {

	ResponseEntity<?> insertar(RegistroProductoDTO datos);


	List<ProductoDTO> listarJoin();
	
	
	ResponseEntity<?> modificar(Long idProducto ,ActualizarProductoDTO datos);
	
	
	ResponseEntity<?> encontrarPorCategoria(Long idCategoria);
	
	
	ResponseEntity<?> encontrarPorMarca(Long idMarca);
	
	
	ResponseEntity<?> filtrarPorCategoriaOMarca(Long idCategoria, Long idMarca);
}
