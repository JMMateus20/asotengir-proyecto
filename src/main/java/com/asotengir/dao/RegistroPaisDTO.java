package com.asotengir.dao;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroPaisDTO {

	
	@NotBlank(message = "debe ingresar el nombre del país")
	private String nomPais;
	
	
	

}
