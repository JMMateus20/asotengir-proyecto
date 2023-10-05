package com.asotengir.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asotengir.dao.CategoriaResponseDTO;
import com.asotengir.dao.MarcaResponseDTO;
import com.asotengir.dao.RegistroCategoriaDTO;
import com.asotengir.dao.RegistroMarcaDTO;
import com.asotengir.model.Categorias;
import com.asotengir.model.Marcas;
import com.asotengir.respository.CategoriaRepository;
import com.asotengir.respository.MarcaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRep;
	
	@Autowired
	private MarcaRepository marcaRep;

	@Override
	public ResponseEntity<?> insertar(RegistroCategoriaDTO datos) {
		Optional<Categorias> categoriaYaExistente=categoriaRep.findByNomCategoria(datos.getNomCategoria());
		if (categoriaYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("ya existe esta categoria");
		}
		Categorias categoriaNueva=new Categorias(datos.getNomCategoria(), datos.getImage());
		categoriaRep.save(categoriaNueva);
		CategoriaResponseDTO response=new CategoriaResponseDTO(categoriaNueva.getIdCategoria(), categoriaNueva.getNomCategoria());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> agregarMarca(RegistroMarcaDTO datos, Long categoriaID) {
		Optional<Categorias> categoriaFound=categoriaRep.findById(categoriaID);
		if (!categoriaFound.isPresent()) {
			return new ResponseEntity<>("categoria no encontrada", HttpStatus.NOT_FOUND);
		}
		Categorias categoriaBD=categoriaFound.get();
		Optional<Marcas> marcaYaExistente=marcaRep.findByNomMarcaPorCategoriaID(datos.getNomMarca(), categoriaBD.getIdCategoria());
		if (marcaYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("marca ya existente en esta categoria");
		}
		Marcas marcaNueva=new Marcas(datos.getNomMarca(), categoriaBD);
		categoriaBD.addMarcas(marcaNueva);
		categoriaRep.save(categoriaBD);
		
		
		MarcaResponseDTO response=new MarcaResponseDTO(categoriaBD.getMarcas().get(categoriaBD.getMarcas().size()-1).getIdMarca(), marcaNueva.getNomMarca());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> listarMarcas(Long categoriaID) {
		Optional<Categorias> categoriaFound=categoriaRep.findById(categoriaID);
		if (!categoriaFound.isPresent()) {
			return new ResponseEntity<>("categoria no encontrada", HttpStatus.NOT_FOUND);
		}
		Categorias categoriaBD=categoriaFound.get();
		List<Marcas> marcas=categoriaBD.getMarcas();
		if (marcas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<MarcaResponseDTO> response=marcas.stream().map(marca->{
			MarcaResponseDTO resp=new MarcaResponseDTO(marca.getIdMarca(), marca.getNomMarca());
			return resp;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<?> eliminarMarca(Long categoriaID, Long marcaID) {
		Optional<Categorias> categoriaFound=categoriaRep.findById(categoriaID);
		if (!categoriaFound.isPresent()) {
			return new ResponseEntity<>("categoria no encontrada", HttpStatus.NOT_FOUND);
		}
		Categorias categoriaBD=categoriaFound.get();
		Optional<Marcas> marcaFound=marcaRep.findById(marcaID);
		if (!marcaFound.isPresent()) {
			return new ResponseEntity<>("marca no encontrada", HttpStatus.NOT_FOUND);
		}
		Optional<Marcas> marcaYaExistente=marcaRep.findByNomMarcaPorCategoriaID(marcaFound.get().getNomMarca(), categoriaID);
		if (!marcaYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("esta marca no pertenece a esta categoria");
		}
		categoriaBD.removeSede(marcaYaExistente.get());
		categoriaRep.save(categoriaBD);
		List<MarcaResponseDTO> response=categoriaBD.getMarcas().stream().map(marca->{
			MarcaResponseDTO resp=new MarcaResponseDTO(marca.getIdMarca(), marca.getNomMarca());
			return resp;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	
	

}
