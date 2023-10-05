package com.asotengir.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarEmpresaDTO {

	
	private String nomEmpresa;
	private String nit;
	private String direccion;
	private String telefono;
	private String email;
	private String web;
	private Long usuarioID;
	private Long tipo;
	private Long paisID;
	private Long estadoID;
	private Long ciudadID;
}
