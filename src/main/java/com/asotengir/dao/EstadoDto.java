package com.asotengir.dao;

public class EstadoDto {
	private Long idEstao;
	private String nomEstado;
	
	public EstadoDto(Long idEstao, String nomEstado) {
		this.idEstao = idEstao;
		this.nomEstado = nomEstado;
	}
	public Long getIdEstao() {
		return idEstao;
	}
	public void setIdEstao(Long idEstao) {
		this.idEstao = idEstao;
	}
	public String getNomEstado() {
		return nomEstado;
	}
	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
	

}
