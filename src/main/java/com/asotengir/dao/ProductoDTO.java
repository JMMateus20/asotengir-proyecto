package com.asotengir.dao;

import java.math.BigDecimal;



import com.asotengir.model.Categorias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

	private Long idProducto;
    private String nomProducto;
    private String descripcion;
    private String modelo;
    
    
    private String nomMarca;

    private String nomCategoria;

    private String baseView;
    
    private Long idMarca;
    private Long idCategoria;
}
