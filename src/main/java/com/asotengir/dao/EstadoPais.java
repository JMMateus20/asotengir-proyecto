package com.asotengir.dao;

public class EstadoPais {
	private String nomPais;
	private String nomEstado;
	private Long idPais;
	private Long id;
	//String nombrePais, String nombre, Long idPais, Long id)
	
	
	public EstadoPais(String nomPais, String nomEstado, Long idPais, Long id) {
		
		this.nomPais = nomPais;
		this.nomEstado = nomEstado;
		this.idPais = idPais;
		this.id = id;
	}
	public String getNomPais() {
		return nomPais;
	}
	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}
	public String getNomEstado() {
		return nomEstado;
	}
	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
