package com.asotengir.services;

import com.asotengir.model.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
