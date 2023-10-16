package com.asotengir.dao;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroProductoDTO {
	@NotBlank(message = "el nombre del producto no puede estar vacío")
	private String nomProducto;
    private String descripcion;
    private String modelo;
    private Long marca;
    @NotNull(message = "El producto debe pertenecer a una categoría específica")
    private Long categoria;
    private String baseView;
    
	public RegistroProductoDTO(@NotBlank(message = "el nombre del producto no puede estar vacío") String nomProducto,
			String descripcion, String modelo, Long marca,
			@NotBlank(message = "El producto debe pertenecer a una categoría específica") Long categoria,
			String baseView) {
		this.nomProducto = nomProducto;
		this.descripcion = (descripcion!=null) ? descripcion:"sin descripción";
		this.modelo = (modelo!=null) ? modelo:"sin modelo";
		this.marca = marca;
		this.categoria = categoria;
		this.baseView = baseView;
	}
    
    
    
}
