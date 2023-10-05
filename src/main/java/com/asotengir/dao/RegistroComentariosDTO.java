package com.asotengir.dao;



import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroComentariosDTO {

	@NotBlank(message = "El campo del comentario no puede estar vacío")
	private String comentario;
}
