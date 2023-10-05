package com.asotengir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.EstadoCiudad;
import com.asotengir.dao.EstadoCiudadDTO;
import com.asotengir.dao.PaisDto;
import com.asotengir.model.Ciudad;
import com.asotengir.model.Pais;
import com.asotengir.respository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	@Autowired
	private CiudadRepository ciudadRep;

	@Override
	public ResponseEntity<List<EstadoCiudadDTO>> listarCiudades() {
		List<EstadoCiudadDTO> response=ciudadRep.listar();
		if (response.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> buscarPorNombre(String nomCiudad) {
		Optional<Ciudad> ciudadFound=ciudadRep.findByNomCiudad(nomCiudad);
		if (!ciudadFound.isPresent()) {
			return new ResponseEntity<>("ciudad no encontrada", HttpStatus.NOT_FOUND);
		}
		Ciudad ciudadBD=ciudadFound.get();
		EstadoCiudad response=new EstadoCiudad(ciudadBD.getNomCiudad(), ciudadBD.getIdCiudad());
		return ResponseEntity.ok(response);
	}

}
