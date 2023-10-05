package com.asotengir.dao;

public class EmpresaDTO {

	private Long idEmpresa;
	private String nomEmpresa;
	private String NIT;
	private String direccion;
	private String telefono;
	private String email;
	private String web;
	private String nombreUsuario;
	private String tipo;
	private String nomPais;
	private String nomEstado;
	private String nomCiudad;
	
	private Long usuarioID;
	private Long tipoID;
	private Long paisID;
	private Long estadoID;
	private Long ciudadID;
	
	
	public EmpresaDTO(Long idEmpresa, String nomEmpresa, String nIT, String direccion, String telefono, String email,
			String web, String nombreUsuario, String tipo, String nomPais, String nomEstado, String nomCiudad, Long usuarioID,
			Long tipoID, Long paisID, Long estadoID, Long ciudadID) {
		this.idEmpresa = idEmpresa;
		this.nomEmpresa = nomEmpresa;
		NIT = nIT;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.web = web;
		this.nombreUsuario = nombreUsuario;
		this.usuarioID=usuarioID;
		this.tipo = tipo;
		this.nomPais = nomPais;
		this.nomEstado = nomEstado;
		this.nomCiudad = nomCiudad;
		this.tipoID = tipoID;
		this.paisID = paisID;
		this.estadoID = estadoID;
		this.ciudadID = ciudadID;
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
		return NIT;
	}
	public void setNIT(String nIT) {
		NIT = nIT;
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
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNomPais() {
		return nomPais;
	}
	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}
	public String getNomEstado() {
		return nomEstado;
	}
	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
	public String getNomCiudad() {
		return nomCiudad;
	}
	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}
	public Long getTipoID() {
		return tipoID;
	}
	public void setTipoID(Long tipoID) {
		this.tipoID = tipoID;
	}
	public Long getPaisID() {
		return paisID;
	}
	public void setPaisID(Long paisID) {
		this.paisID = paisID;
	}
	public Long getEstadoID() {
		return estadoID;
	}
	public void setEstadoID(Long estadoID) {
		this.estadoID = estadoID;
	}
	public Long getCiudadID() {
		return ciudadID;
	}
	public void setCiudadID(Long ciudadID) {
		this.ciudadID = ciudadID;
	}
	public Long getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(Long usuarioID) {
		this.usuarioID = usuarioID;
	}
	
	
	
	
	
	
	
}
