package com.asotengir.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.EstadoCiudad;
import com.asotengir.dao.EstadoDto;
import com.asotengir.dao.PaisDto;
import com.asotengir.dao.RegistroCiudadDTO;
import com.asotengir.dao.RegistroEstadoDTO;
import com.asotengir.model.Ciudad;
import com.asotengir.model.Estado;
import com.asotengir.model.Pais;
import com.asotengir.respository.CiudadRepository;
import com.asotengir.respository.EstadoRepository;
import com.asotengir.respository.PaisRepository;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	private EstadoRepository estadoRep;
	
	@Autowired
	private CiudadRepository ciudadRep;
	

	@Override
	public ResponseEntity<?> agregarCiudad(RegistroCiudadDTO datos, Long estadoID) {
		Optional<Estado> estadoFound=estadoRep.findById(estadoID);
		if (!estadoFound.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Estado estadoBD=estadoFound.get();
		Ciudad ciudadNueva=new Ciudad(datos.getNomCiudad(), estadoBD);
		estadoBD.addCiudad(ciudadNueva);
		estadoRep.save(estadoBD);
		return ResponseEntity.ok("ok");
	}


	@Override
	public ResponseEntity<?> buscar(Long idEstado) {
		Optional<Estado> estadoFound=estadoRep.findById(idEstado);
		if (!estadoFound.isPresent()) {
			return new ResponseEntity<>("estado no encontrado", HttpStatus.NOT_FOUND);
		}
		Estado estadoBD=estadoFound.get();
		EstadoDto response=new EstadoDto(estadoBD.getIdEstado(), estadoBD.getNomEstado());
		return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<?> listarCiudades(Long idEstado) {
		Optional<Estado> estadoFound=estadoRep.findById(idEstado);
		if (!estadoFound.isPresent()) {
			return new ResponseEntity<>("estado no encontrado", HttpStatus.NOT_FOUND);
		}
		List<Ciudad> ciudades=ciudadRep.findByEstado(estadoFound.get());
		List<EstadoCiudad> response=ciudades.stream()
				.map(ciudad->{
					EstadoCiudad resp=new EstadoCiudad(ciudad.getNomCiudad(), ciudad.getIdCiudad());
					return resp;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	


	

}
