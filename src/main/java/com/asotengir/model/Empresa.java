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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	private String nomEmpresa;
	private String NIT;
	private String direccion;
	private String telefono;
	private String email;
	private String web;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoEmpresa tipo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "pais_id")
	@JsonProperty(access = Access.WRITE_ONLY) 
	private Pais pais; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estado_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Estado estado;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ciudad_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Ciudad ciudad;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<EmpresaProducto> usuarioProducto;
	
	
	
	
	public Empresa(String nomEmpresa, String NIT, String direccion, String telefono, String email, String web,
			Usuario usuario, TipoEmpresa tipo, Pais pais, Estado estado, Ciudad ciudad) {
		this.nomEmpresa = nomEmpresa;
		this.NIT = NIT;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.web = web;
		this.usuario = usuario;
		this.tipo=tipo;
		this.pais = pais;
		this.estado = estado;
		this.ciudad = ciudad;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public String getNomEmpresa() {
		return nomEmpresa;
	}
	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}
	public String getNIT() {
		return this.NIT;
	}
	public void setNIT(String nIT) {
		this.NIT = nIT;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public List<EmpresaProducto> getUsuarioProducto() {
		return usuarioProducto;
	}
	public void setUsuarioProducto(List<EmpresaProducto> usuarioProducto) {
		this.usuarioProducto = usuarioProducto;
	}
	public void addProductos(EmpresaProducto producto) {

		this.usuarioProducto.add(producto);
	}

	public void removeProducto(EmpresaProducto producto) {

		this.usuarioProducto.remove(producto);
	}
	
	
	
	public TipoEmpresa getTipo() {
		return tipo;
	}
	public void setTipo(TipoEmpresa tipo) {
		this.tipo = tipo;
	}

	

}
