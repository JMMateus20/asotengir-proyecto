package com.asotengir.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroCiudadDTO {

	@NotBlank(message = "debe ingresar un nombre para la ciudad")
	private String nomCiudad;
}
