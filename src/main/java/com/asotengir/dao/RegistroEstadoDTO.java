package com.asotengir.dao;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEstadoDTO {

	
	@NotBlank(message = "el nombre no puede estar vacío")
	private String nomEstado;
}
