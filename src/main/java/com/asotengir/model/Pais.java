package com.asotengir.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long idPais;
	
	@NotNull(message = "El nombre no puede ser nulo")
	private String nomPais;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy="pais",
            cascade = CascadeType.ALL
    )
	private List <Estado> estados;
	
	
	public Pais() {
		this.estados=new ArrayList<Estado>();
	}
	
	
	
	public Pais(@NotNull(message = "El nombre no puede ser nulo") String nomPais) {
		this.nomPais = nomPais;
	}



	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	
	public String getNomPais() {
		return nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	public void addEstado(Estado estado) {
		this.estados.add(estado);
	}
	public void removeEstado(Estado estado) {
		this.estados.remove(estado);
	}
}
