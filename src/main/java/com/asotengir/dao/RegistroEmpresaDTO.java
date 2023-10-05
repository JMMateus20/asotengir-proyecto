package com.asotengir.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEmpresaDTO {

	private String nomEmpresa;
	
	@JsonProperty("NIT")
	@NotBlank(message = "el NIT no puede estar vacío")
	private String NIT;
	
	private String direccion;
	
	@NotBlank(message = "el campo telefono no puede estar vacío")
	private String telefono;
	
	@Email(message = "el campo email debe ser un email válido")
	private String email;
	private String web;
	@NotNull(message = "el usuario no puede ser nulo")
	private Long usuarioID;
	@NotBlank(message = "la empresa debe ser de algun tipo")
	private String tipo;
	@NotNull(message = "debe ingresar el pais")
	private Long paisID;
	@NotNull(message = "debe ingresar el estado")
	private Long estadoID;
	@NotNull(message = "debe ingresar la ciudad")
	private Long ciudadID;
	
	
}
