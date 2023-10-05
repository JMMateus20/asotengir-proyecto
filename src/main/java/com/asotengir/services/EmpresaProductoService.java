package com.asotengir.services;

import org.springframework.http.ResponseEntity;

import com.asotengir.dao.RegistroComentariosDTO;

public interface EmpresaProductoService {

	ResponseEntity<?> agregarComentarios(Long empresaProductoID ,RegistroComentariosDTO comentario);


	ResponseEntity<?> listarPorEmpresa(String nomEmpresa);
	
	
	ResponseEntity<?> listarPorLocacion(String nomPais, String nomEstado, String nomCiudad);


	ResponseEntity<?> listarProductosDeEmpresasDeUsuario(Long usuarioID);
}
