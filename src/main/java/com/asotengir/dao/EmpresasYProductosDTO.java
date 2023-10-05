package com.asotengir.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresasYProductosDTO {

	private String nomEmpresa;
    private String nomPais;
    private String nomEstado;
    private String nomCiudad;
	private Map<String, Object> productos=new HashMap<>();
}
