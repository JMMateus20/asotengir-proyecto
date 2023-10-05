package com.asotengir.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;


@Entity
@Table(name="tipo_empresa")
public class TipoEmpresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipo;
	private String tipo;
	@OneToMany(mappedBy = "tipo")
	private List<Empresa> empresas=new ArrayList<>();
	
	
	
	public TipoEmpresa(String tipo) {
		this.tipo = tipo;
	}
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public TipoEmpresa() {
	
	}
	
	

}
