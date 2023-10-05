package com.asotengir.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class EmpresaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUP;
	private Long cantidad;
	private BigDecimal precio;
	private Integer stockItems;
	private Integer calificacion;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empresa_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "producto_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Productos producto;
	
	@OneToMany(mappedBy="producto",
            cascade = CascadeType.ALL
    )
	private List <Comentarios> comentarios=new ArrayList <Comentarios>();
	
	
	
	public EmpresaProducto(Long cantidad, BigDecimal precio, Integer stockItems, Integer calificacion, Empresa empresa,
			Productos producto) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.stockItems = stockItems;
		this.calificacion = calificacion;
		this.empresa = empresa;
		this.producto = producto;
	}

	public Long getIdUP() {
		return idUP;
	}

	public void setIdUP(Long idUP) {
		this.idUP = idUP;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStockItems() {
		return stockItems;
	}

	public void setStockItems(Integer stockItems) {
		this.stockItems = stockItems;
	}

	
	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	
	public void addComments(Comentarios comentario) {
		comentario.setProducto(this);
		this.comentarios.add(comentario);
	}

}
