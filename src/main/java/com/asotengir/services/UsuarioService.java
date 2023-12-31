package com.asotengir.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asotengir.dao.IUsuarioDao;
import com.asotengir.dao.RegistroUsuarioDTO;
import com.asotengir.model.Usuario;
import com.asotengir.respository.UsuarioRepository;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private UsuarioRepository usuarioRep;

	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}
	
	
	public ResponseEntity<?> insertar(RegistroUsuarioDTO datos){
		Optional<Usuario> usuarioYaExistente=usuarioRep.findByUsername(datos.getUsername());
		if (usuarioYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("usuario Ya existente");
		}
		
		Usuario usuarioNuevo=new Usuario(datos.getUsername(), datos.getPassword(), datos.getNombreUsuario(), datos.getApellido(), datos.getEmail());
		usuarioRep.save(usuarioNuevo);
		return ResponseEntity.ok("USUARIO AGREGADO");
	}

}
