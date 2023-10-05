package com.asotengir.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.asotengir.model.Categorias;
import com.asotengir.model.Comentarios;
import com.asotengir.model.Empresa;
import com.asotengir.model.Marcas;
import com.asotengir.model.Productos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpresaProductoJoinDTO {
	private Long idUP;
	
    private String nomProducto;
    private String descripcion;
    private String modelo;
    
    
    private String nomMarca;

    private String nomCategoria;

    private String baseView;

	private Long cantidad;
	
	private BigDecimal precio;
	private Integer stockItems;
	private Integer calificacion;

	private List <ComentariosResponseDTO> comentarios=new ArrayList <>();
	
	public EmpresaProductoJoinDTO(Long idUP, String nomProducto, String descripcion, String modelo, String nomMarca,
			String nomCategoria, String baseView, Long cantidad, BigDecimal precio, Integer stockItems,
			Integer calificacion) {
		this.idUP = idUP;
		this.nomProducto = nomProducto;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.nomMarca = nomMarca;
		this.nomCategoria = nomCategoria;
		this.baseView = baseView;
		this.cantidad = cantidad;
		this.precio = precio;
		this.stockItems = stockItems;
		this.calificacion = calificacion;
	}



	
}
