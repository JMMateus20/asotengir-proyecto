package com.asotengir.dao;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroTipoDTO {

	@NotBlank(message = "para registrar el tipo de empresa, coloque el nombre")
	private String tipo;
}
