package com.asotengir.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import com.asotengir.dao.EstadoDto;
import com.asotengir.dao.PaisDto;
import com.asotengir.dao.RegistroEstadoDTO;
import com.asotengir.dao.RegistroPaisDTO;
import com.asotengir.model.Estado;
import com.asotengir.model.Pais;
import com.asotengir.respository.EstadoRepository;
import com.asotengir.respository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository paisRep;
	
	@Autowired
	private EstadoRepository estadoRep;
	
	@Autowired
	private ValidacionService validacionService;

	@Override
	public ResponseEntity<?> registrar(RegistroPaisDTO datos) {
		Optional<Pais> paisYaExistente=paisRep.findByNomPais(datos.getNomPais());
		if (paisYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("");
		}
		Pais paisNuevo=new Pais(datos.getNomPais());
		paisRep.save(paisNuevo);
		return ResponseEntity.ok("registrado");
	}
	
	@Override
	public ResponseEntity<?> agregarEstado(@Valid RegistroEstadoDTO datos, Long idPais){
		
		Optional<Pais> paisFound=paisRep.findById(idPais);
		if (!paisFound.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pais paisBD=paisFound.get();
		Optional<Estado> estadoYaExistente=estadoRep.findByNomEstado(datos.getNomEstado());
		if (estadoYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("estado ya existente en la base de datos");
		}
		Estado estadoNuevo=new Estado(datos.getNomEstado(), paisBD);
		paisBD.addEstado(estadoNuevo);
		paisRep.save(paisBD);
		return ResponseEntity.ok("estado agregado");
	}

	@Override
	public ResponseEntity<?> buscar(Long idPais) {
		Optional<Pais> paisFound=paisRep.findById(idPais);
		if (!paisFound.isPresent()) {
			return new ResponseEntity<>("pais no encontrado", HttpStatus.NOT_FOUND);
		}
		Pais paisBD=paisFound.get();
		PaisDto response=new PaisDto(paisBD.getIdPais(), paisBD.getNomPais());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> buscarEstados(Long idPais, Pageable page) {
		Optional<Pais> paisFound=paisRep.findById(idPais);
		if (!paisFound.isPresent()) {
			return new ResponseEntity<>("pais no encontrado", HttpStatus.NOT_FOUND);
		}
		Page<Estado> estados=estadoRep.findByPais(paisFound.get(), page);
		if (!estados.hasContent()) {
			return ResponseEntity.noContent().build();
		}
		List<EstadoDto> response=estados.getContent().stream()
				.map(estado->{
					EstadoDto resp=new EstadoDto(estado.getIdEstado(), estado.getNomEstado());
					return resp;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(response);
		
	}
	
	

}
