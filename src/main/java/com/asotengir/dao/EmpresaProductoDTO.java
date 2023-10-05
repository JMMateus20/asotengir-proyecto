package com.asotengir.dao;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaProductoDTO {

	
	
	@Positive(message = "la cantidad debe ser mayor a cero")
	@NotNull(message = "ingrese la cantidad")
	private Long cantidad;
	@Positive(message = "el precio debe ser mayor a cero")
	@NotNull(message = "el precio no puede ser nulo")
	private BigDecimal precio;
	@Positive(message = "el stock debe ser mayor a cero")
	@NotNull(message = "el stock no puede ser nulo")
	private Integer stockItems;
	@Positive(message = "la calificacion no puede ser negativa")
	private Integer calificacion;
	

	@NotNull
	private Long idEmpresa;

	@NotNull
	private Long idProducto;
}
