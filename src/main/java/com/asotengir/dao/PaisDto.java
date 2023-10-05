package com.asotengir.dao;

public class PaisDto {
	private Long id;
	private String nomPais;
	
	public PaisDto(Long id, String nomPais) {
		
		this.id = id;
		this.nomPais = nomPais;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPais() {
		return nomPais;
	}
	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}
	
	
	
	

}
