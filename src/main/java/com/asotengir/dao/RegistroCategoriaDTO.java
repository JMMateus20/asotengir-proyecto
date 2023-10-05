package com.asotengir.dao;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroCategoriaDTO {
	@NotBlank(message = "la categoria no puede estar vacía")
	private String nomCategoria;
	private String image;
}
