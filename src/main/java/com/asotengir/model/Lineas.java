package com.asotengir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Lineas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLinea;
	private String nomLinea;
	private Integer nivel;
	public Long getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}
	public String getNomLinea() {
		return nomLinea;
	}
	public void setNomLinea(String nomLinea) {
		this.nomLinea = nomLinea;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	

}
