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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
//@JsonIgnoreType
public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long idEstado;
	
	@NotNull(message = "El username no puede ser nulo")
	private String nomEstado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "pais_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	//@JsonIgnoreProperties(value= {"estado"},allowSetters = true)
	private Pais pais;


	
	
	
	@OneToMany(mappedBy="estado",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
	private List <Ciudad> ciudades;
	
	
	
	
	public Estado(@NotNull(message = "El username no puede ser nulo") String nomEstado, Pais pais) {
		this.nomEstado = nomEstado;
		this.pais = pais;
	}


	public Estado() {
		this.ciudades=new ArrayList<Ciudad>();
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


	
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public void addCiudad(Ciudad ciudad) {
		this.ciudades.add(ciudad);
	}
	public void removeEstado(Ciudad ciudad) {
		this.ciudades.remove(ciudad);
	}
	
	
}
