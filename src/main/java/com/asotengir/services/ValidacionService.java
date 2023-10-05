package com.asotengir.services;

import org.springframework.validation.BindingResult;

public interface ValidacionService {

	String formatarMensaje(BindingResult resultado);
}
