package com.asotengir.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaResponseDTO {

	
	private Long idEmpresa;
	private String nomEmpresa;
	private String NIT;
	private String direccion;
	private String telefono;
	private String email;
	private String web;


	private Long idUsuario;
	
	
	private String tipo;

	private String nomPais; 

	private String nomEstado;

	private String nomCiudad;
}
