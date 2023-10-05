package com.asotengir.dao;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarProductoDTO {
	
    private String nomProducto;
    private String descripcion;
    private String modelo;
    
    

    private String nomMarca;

    private String nomCategoria;

    private String baseView;
}
