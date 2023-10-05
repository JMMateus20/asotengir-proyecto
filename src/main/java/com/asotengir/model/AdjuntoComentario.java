package com.asotengir.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class AdjuntoComentario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	//@NotNull(message = "La descripcion no puede ser nulo")
	private String descripcion;
	//@NotNull(message = "El adjunto no puede ser nulo")
	private String fileName;
	private String type;
	private Long size;
	private Date fecha;
	@Lob
	private byte[] data;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "comentario_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Comentarios comentario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Comentarios getComentario() {
		return comentario;
	}

	public void setComentario(Comentarios comentario) {
		this.comentario = comentario;
	}
	
}
