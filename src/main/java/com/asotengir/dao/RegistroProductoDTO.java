package com.asotengir.dao;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroProductoDTO {
	@NotBlank(message = "el nombre del producto no puede estar vacío")
	private String nomProducto;
    private String descripcion;
    private String modelo;
    private String marca;
    @NotBlank(message = "El producto debe pertenecer a una categoría específica")
    private String categoria;
    private String baseView;
    
}
