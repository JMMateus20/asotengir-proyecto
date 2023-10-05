package com.asotengir.dao;

public class EstadoCiudad {
	
	private Long idCiudad;
	private String nomCiudad;
	
	
	public EstadoCiudad(String nomCiudad, Long idCiudad) {
		
		this.nomCiudad = nomCiudad;
		this.idCiudad = idCiudad;
	}
	public String getNomCiudad() {
		return nomCiudad;
	}
	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
	
}
