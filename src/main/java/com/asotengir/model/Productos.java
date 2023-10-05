package com.asotengir.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nomProducto;
    private String descripcion;
    private String modelo;
    
    

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marcas marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;

    private String baseView;

    

	public Productos(String nomProducto, String descripcion, String modelo,
			Marcas marca, Categorias categoria, String baseView) {
		this.nomProducto = nomProducto;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = categoria;
		this.baseView = baseView;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public String getBaseView() {
		return baseView;
	}

	public void setBaseView(String baseView) {
		this.baseView = baseView;
	}

    
}