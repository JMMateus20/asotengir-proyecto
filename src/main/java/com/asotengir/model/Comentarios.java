package com.asotengir.model;

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
public class Comentarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private Long idComentario;
	
	private String comentario;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "catalogo_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private EmpresaProducto producto;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="comentario")
	private List <AdjuntoComentario> adjunto=new ArrayList <AdjuntoComentario>();
	
	
	
	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public EmpresaProducto getProducto() {
		return producto;
	}
	public void setProducto(EmpresaProducto producto) {
		this.producto = producto;
	}
	public List<AdjuntoComentario> getAdjunto() {
		return adjunto;
	}
	public void setAdjunto(List<AdjuntoComentario> adjunto) {
		this.adjunto = adjunto;
	}
	public Comentarios(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
