package com.asotengir.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpresaProductoJoinDTO2 {
	
	private Long idUP;
	
    private String nomEmpresa;
    private String nomPais;
    private String nomEstado;
    private String nomCiudad;
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

	public EmpresaProductoJoinDTO2(Long idUP, String nomEmpresa, String nomPais, String nomEstado, String nomCiudad,
			String nomProducto, String descripcion, String modelo, String nomMarca, String nomCategoria,
			String baseView, Long cantidad, BigDecimal precio, Integer stockItems, Integer calificacion) {
		this.idUP = idUP;
		this.nomEmpresa = nomEmpresa;
		this.nomPais = nomPais;
		this.nomEstado = nomEstado;
		this.nomCiudad = nomCiudad;
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
