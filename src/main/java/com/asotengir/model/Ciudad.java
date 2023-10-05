package com.asotengir.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private	Long idCiudad;
	
	@NotNull(message = "El username no puede ser nulo")
	private String nomCiudad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnoreProperties(value= {"ciudad"})
	private Estado estado; 
	
	
	
	public Ciudad(@NotNull(message = "El username no puede ser nulo") String nomCiudad, Estado estado) {
		this.nomCiudad = nomCiudad;
		this.estado = estado;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
	public String getNomCiudad() {
		return nomCiudad;
	}
	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
