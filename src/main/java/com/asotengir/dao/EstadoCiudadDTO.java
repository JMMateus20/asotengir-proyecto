package com.asotengir.dao;

public class EstadoCiudadDTO {
	private String nomEstado;
	private String nomCiudad;
	private String nomPais;
	private Long idEstado;
	private Long idPais;
	private Long id;

	
	public EstadoCiudadDTO(String nomCiudad,Long id,String nomEstado,Long idEstado,String nomPais,Long idPais) {
		this.nomEstado = nomEstado;
		this.nomCiudad = nomCiudad;
		
		this.idEstado = idEstado;
		this.nomPais=nomPais;
		this.idPais=idPais;
		this.id = id;
	}
	
	public String getNomEstado() {
		return nomEstado;
	}
	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
	public String getNomCiudad() {
		return nomCiudad;
	}
	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
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

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	
	
	

	
	
	
	
	
}
