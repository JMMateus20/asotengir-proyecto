package com.asotengir.dao;

public class CommonsPaisCiudadEstado {
	private String nomEstado;
	
	private Long idEstado;

	public CommonsPaisCiudadEstado(String nomEstado, Long idEstado) {
	
		this.nomEstado = nomEstado;
		this.idEstado = idEstado;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
}
