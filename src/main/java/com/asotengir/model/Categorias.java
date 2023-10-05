package com.asotengir.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	private String nomCategoria;
	private String image;
	
	@OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Marcas> marcas;

	
	

	public Categorias(String nomCategoria, String image) {
		this.nomCategoria = nomCategoria;
		this.image = image;
	}



	public Long getIdCategoria() {
		return idCategoria;
	}

	

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public List<Marcas> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marcas> marcas) {
		this.marcas = marcas;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void addMarcas(Marcas marca) {
		this.marcas.add(marca);
	}

	public void removeSede(Marcas marca) {
		this.marcas.remove(marca);
	}
	
}