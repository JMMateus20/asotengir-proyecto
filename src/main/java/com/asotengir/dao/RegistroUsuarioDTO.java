package com.asotengir.dao;

import javax.persistence.Column;
import javax.validation.constraints.Email;

public class RegistroUsuarioDTO {


	private String username;


	private String password;


	private String nombreUsuario;
	
	private String apellido;

	@Email(message = "el campo email debe ser un email valido")
	private String email;


	public RegistroUsuarioDTO() {
	
	}

	public RegistroUsuarioDTO(String username, String password, String nombreUsuario, String apellido, String email) {
		this.username = username;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.apellido = apellido;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
