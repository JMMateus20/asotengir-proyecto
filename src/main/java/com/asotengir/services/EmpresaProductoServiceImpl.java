package com.asotengir.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.ComentariosResponseDTO;
import com.asotengir.dao.EmpresaProductoJoinDTO;
import com.asotengir.dao.EmpresaProductoJoinDTO2;
import com.asotengir.dao.EmpresaProductoJoinDTO3;
import com.asotengir.dao.EmpresasYProductosDTO;
import com.asotengir.dao.RegistroComentariosDTO;
import com.asotengir.model.Comentarios;
import com.asotengir.model.EmpresaProducto;
import com.asotengir.respository.ComentarioRepository;
import com.asotengir.respository.EmpresaProductoRepository;
import com.asotengir.respository.EmpresaRepository;

@Service
public class EmpresaProductoServiceImpl implements EmpresaProductoService{
	
	@Autowired
	private EmpresaProductoRepository epRep;
	
	@Autowired
	private ComentarioRepository comentarioRep;
	
	@Autowired
	private EmpresaRepository empresaRep;
	

	@Override
	public ResponseEntity<?> agregarComentarios(Long empresaProductoID, RegistroComentariosDTO comentario) {
		Optional<EmpresaProducto> epFound=epRep.findById(empresaProductoID);
		if (!epFound.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		EmpresaProducto epBD=epFound.get();
		Comentarios comment=new Comentarios(comentario.getComentario());
		epBD.addComments(comment);
		epRep.save(epBD);
		return ResponseEntity.ok(epBD);
	}


	@Override
	public ResponseEntity<?> listarPorEmpresa(String nomEmpresa) {
		List<EmpresaProductoJoinDTO> response=epRep.listarPorEmpresa(nomEmpresa);
		if (response.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		 
		for (EmpresaProductoJoinDTO registro:response) {
			List<ComentariosResponseDTO> comentarios=comentarioRep.comentariosPorRegistro(registro.getIdUP());
			if (!comentarios.isEmpty()) {
				registro.setComentarios(comentarios);
			}
			if (registro.getNomMarca()==null) {
				registro.setNomMarca("Sin marca");
			}
			
		}
		return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<?> listarPorLocacion(String nomPais, String nomEstado, String nomCiudad) {
		List<EmpresaProductoJoinDTO2> response=epRep.listarPorLocacion(nomPais, nomEstado, nomCiudad);
		if (response.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		for (EmpresaProductoJoinDTO2 registro:response) {
			List<ComentariosResponseDTO> comentarios=comentarioRep.comentariosPorRegistro(registro.getIdUP());
			if (!comentarios.isEmpty()) {
				registro.setComentarios(comentarios);
			}
			if (registro.getNomMarca()==null) {
				registro.setNomMarca("Sin marca");
				
			}
			
			
		}
		return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<?> listarProductosDeEmpresasDeUsuario(Long usuarioID) {
		Map<String, Object> productosPorEmpresa=new HashMap<>();
		List<EmpresaProductoJoinDTO3> empresas=empresaRep.listarPorUsuario(usuarioID);
		List<EmpresasYProductosDTO> empresasYproductos=new ArrayList<>();
		for (EmpresaProductoJoinDTO3 empresa:empresas) {
			List<EmpresaProductoJoinDTO> productos=epRep.listarPorEmpresa(empresa.getNomEmpresa());
			productosPorEmpresa.put("productos", productos);
			EmpresasYProductosDTO response=new EmpresasYProductosDTO(empresa.getNomEmpresa(), empresa.getNomPais(), empresa.getNomEstado(), empresa.getNomCiudad(), productosPorEmpresa);
			empresasYproductos.add(response);
		}
		return ResponseEntity.ok(empresasYproductos);
	}

}
