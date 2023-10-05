package com.asotengir.dao;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaProductoResponseDTO {

	private Long idUP;
	private Long idProducto;
	private Long cantidad;
	private BigDecimal precio;
	private Long idEmpresa;
}
