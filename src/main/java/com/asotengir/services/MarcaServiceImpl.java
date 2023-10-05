package com.asotengir.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.ActualizarCategoriaDeMarcaDTO;
import com.asotengir.dao.ActualizarNombreDeMarcaDTO;
import com.asotengir.dao.MarcaResponseDTO;
import com.asotengir.model.Categorias;
import com.asotengir.model.Marcas;
import com.asotengir.respository.CategoriaRepository;
import com.asotengir.respository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService{
	
	@Autowired
	private CategoriaRepository categoriaRep;
	
	@Autowired
	private MarcaRepository marcaRep;

	@Override
	public ResponseEntity<?> actualizarCategoria(ActualizarCategoriaDeMarcaDTO datos, Long marcaID) {
		Optional<Marcas> marcaFound=marcaRep.findById(marcaID);
		if (!marcaFound.isPresent()) {
			return new ResponseEntity<>("marca no encontrada", HttpStatus.NOT_FOUND);
		}
		Marcas marcaBD=marcaFound.get();
		
		Optional<Categorias> categoriaFound=categoriaRep.findById(datos.getCategoriaID());
		if (!categoriaFound.isPresent()) {
			return new ResponseEntity<>("categoria no encontrada", HttpStatus.NOT_FOUND);
		}
		Categorias categoriaBD=categoriaFound.get();
		List<Marcas> marcasYaExistentes=categoriaBD.getMarcas().stream().filter(marca->marca.getNomMarca().equals(marcaBD.getNomMarca())).toList();
		if (!marcasYaExistentes.isEmpty()) {
			return ResponseEntity.badRequest().body("esta marca ya se encuentra en la categoria ingresada");
		}
		
		marcaBD.setCategorias(categoriaBD);
		categoriaBD.addMarcas(marcaBD);
		categoriaRep.save(categoriaBD);
		List<MarcaResponseDTO> response=categoriaBD.getMarcas().stream().map(marca->{
			MarcaResponseDTO resp=new MarcaResponseDTO(marca.getIdMarca(), marca.getNomMarca());
			return resp;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	
	}

	@Override
	public ResponseEntity<?> actualizarNombre(ActualizarNombreDeMarcaDTO datos, Long marcaID) {
		Optional<Marcas> marcaFound=marcaRep.findById(marcaID);
		if (!marcaFound.isPresent()) {
			return new ResponseEntity<>("marca no encontrada", HttpStatus.NOT_FOUND);
		}
		Marcas marcaBD=marcaFound.get();
		Categorias categoriaBD=categoriaRep.findById(marcaBD.getCategorias().getIdCategoria()).get();
		Optional<Marcas> marcaYaExistente=marcaRep.findByNomMarca(datos.getNombre());
		if (marcaYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("esta marca ya existe en la base de datos");
		}
		int index=categoriaBD.getMarcas().indexOf(marcaBD);
		marcaBD.setNomMarca(datos.getNombre());
		categoriaBD.getMarcas().set(index, marcaBD);
		categoriaRep.save(categoriaBD);
		MarcaResponseDTO response=new MarcaResponseDTO(marcaBD.getIdMarca(), marcaBD.getNomMarca());
		return ResponseEntity.ok(response);
	}
	
	

}
