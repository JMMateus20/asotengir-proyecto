package com.asotengir.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroMarcaDTO {

	@NotBlank(message = "Para registrar una nueva marca, debe colocarle un nombre")
	private String nomMarca;
}
