package com.asotengir.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioID;

	@Column(unique = true, length = 20)
	private String username;

	@Column(length = 60)
	private String password;

	private Boolean enabled=true;
	
	private String nombreUsuario;
	private String apellido;
	
	@Column(unique = true)
	private String email;
	@CreatedDate
	  private LocalDateTime createdAt;
	  
	  @LastModifiedDate
	  private LocalDateTime updatedAt;
	  
	  @CreatedBy
	  @ManyToOne(fetch = FetchType.LAZY)
	  private Usuario createdBy;
	  
	  @LastModifiedBy
	  @ManyToOne(fetch = FetchType.LAZY)
	  private Usuario updatedBy;
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "role_id"})})
	private List<Role> roles;
	@OneToMany(mappedBy="usuario",
	         cascade = {CascadeType.PERSIST, CascadeType.MERGE}
	)
		
	private List <Empresa> empresa;
	

	public Long getId() {
		return usuarioID;
	}

	public void setId(Long id) {
		this.usuarioID = id;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
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
	
	

	public Usuario(String username, String password, String nombreUsuario, String apellido, String email) {
		this.username = username;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.apellido = apellido;
		this.email = email;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
}
