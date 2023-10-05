package com.asotengir.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;



@NoArgsConstructor
@Entity
public class Marcas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    private String nomMarca;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categorias_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Categorias categorias;


	

	public Marcas(String nomMarca, Categorias categorias) {
		this.nomMarca = nomMarca;
		this.categorias = categorias;
	}

	public String getNomMarca() {
		return nomMarca;
	}

	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	
	
		
}