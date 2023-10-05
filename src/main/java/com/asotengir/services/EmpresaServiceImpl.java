package com.asotengir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.ActualizarEmpresaDTO;
import com.asotengir.dao.EmpresaDTO;
import com.asotengir.dao.EmpresaProductoDTO;
import com.asotengir.dao.EmpresaProductoResponseDTO;
import com.asotengir.dao.EmpresaResponseDTO;
import com.asotengir.dao.RegistroEmpresaDTO;
import com.asotengir.dao.RegistroTipoDTO;
import com.asotengir.model.Ciudad;
import com.asotengir.model.Empresa;
import com.asotengir.model.EmpresaProducto;
import com.asotengir.model.Estado;
import com.asotengir.model.Pais;
import com.asotengir.model.Productos;
import com.asotengir.model.TipoEmpresa;
import com.asotengir.model.Usuario;
import com.asotengir.respository.CiudadRepository;
import com.asotengir.respository.EmpresaRepository;
import com.asotengir.respository.EstadoRepository;
import com.asotengir.respository.PaisRepository;
import com.asotengir.respository.ProductoRepository;
import com.asotengir.respository.TipoEmpresaRepository;
import com.asotengir.respository.UsuarioRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	private EstadoRepository estadoRep;
	
	
	@Autowired
	private CiudadRepository ciudadRep;
	
	@Autowired
	private PaisRepository paisRep;
	
	@Autowired
	private TipoEmpresaRepository tipoEmpresaRep;
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Autowired
	private EmpresaRepository empresaRep;
	
	@Autowired
	private ProductoRepository productoRep;
	
	

	@Override
	public ResponseEntity<?> insertar(RegistroEmpresaDTO datos) {
		Optional<Empresa> empresaYaExistente=empresaRep.findByNomEmpresa(datos.getNomEmpresa());
		if (empresaYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("esta empresa ya existe en la base de datos");
		}
		Optional<Usuario> usuarioFound=usuarioRep.findById(datos.getUsuarioID());
		if (!usuarioFound.isPresent()) {
			return new ResponseEntity<>("Este usuario no fue encontrado o no existe", HttpStatus.NOT_FOUND);
		}
		Usuario usuarioBD=usuarioFound.get();
		Optional<TipoEmpresa> tipoFound=tipoEmpresaRep.findByTipo(datos.getTipo());
		if (!tipoFound.isPresent()) {
			return new ResponseEntity<>("Tipo de empresa no existente", HttpStatus.NOT_FOUND);
		}
		TipoEmpresa tipoBD=tipoFound.get();
		Optional<Pais> paisFound=paisRep.findById(datos.getPaisID());
		if (!paisFound.isPresent()) {
			return new ResponseEntity<>("Este pais no fue encontrado o no existe", HttpStatus.NOT_FOUND);
		}
		Pais paisBD=paisFound.get();
		Optional<Ciudad> ciudadFound=ciudadRep.findById(datos.getCiudadID());
		if (!ciudadFound.isPresent()) {
			return new ResponseEntity<>("Esta ciudad no fue encontrada o no existe", HttpStatus.NOT_FOUND);
		}
		Ciudad ciudadBD=ciudadFound.get();
		Optional<Estado> estadoFound=estadoRep.findById(datos.getEstadoID());
		if (!estadoFound.isPresent()) {
			return new ResponseEntity<>("Este estado no fue encontrado o no existe", HttpStatus.NOT_FOUND);
		}
		Estado estadoBD=estadoFound.get();
		if (!(ciudadBD.getEstado()==estadoBD && estadoBD.getPais()==paisBD)) {
			return ResponseEntity.badRequest().body("la ciudad ingresada debe pertenecer al estado ingresado, y el estado ingresado debe pertenecer al país ingresado ");
		}
		Empresa empresaNueva=new Empresa(datos.getNomEmpresa(), datos.getNIT(), datos.getDireccion(), datos.getTelefono(), datos.getEmail(), datos.getWeb(), usuarioBD , tipoBD, paisBD, estadoBD, ciudadBD);
		
		empresaRep.save(empresaNueva);
		EmpresaResponseDTO response=new EmpresaResponseDTO(empresaNueva.getIdEmpresa(), empresaNueva.getNomEmpresa(), empresaNueva.getNIT(), empresaNueva.getDireccion(), empresaNueva.getTelefono(), empresaNueva.getEmail(), empresaNueva.getWeb(), empresaNueva.getUsuario().getId(), empresaNueva.getTipo().getTipo(), empresaNueva.getPais().getNomPais(), empresaNueva.getEstado().getNomEstado(), empresaNueva.getCiudad().getNomCiudad());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<List<EmpresaDTO>> jointable() {
		return ResponseEntity.ok(empresaRep.listarEmpresas());
	}

	@Override
	public ResponseEntity<?> agregarProducto(EmpresaProductoDTO datos) {
		Optional<Empresa> empresaFound=empresaRep.findById(datos.getIdEmpresa());
		if (!empresaFound.isPresent()) {
			return new ResponseEntity<>("empresa no encontrada o no existente", HttpStatus.NOT_FOUND);
		}
		Empresa empresaBD=empresaFound.get();
		Optional<Productos> productoFound=productoRep.findById(datos.getIdProducto());
		if (!productoFound.isPresent()) {
			return new ResponseEntity<>("producto no encontrado o no existente", HttpStatus.NOT_FOUND);
		}
		Productos productoBD=productoFound.get();
		EmpresaProducto ep=new EmpresaProducto(datos.getCantidad(), datos.getPrecio(), datos.getStockItems(), datos.getCalificacion(), empresaBD, productoBD);
		empresaBD.addProductos(ep);
		empresaRep.save(empresaBD);
		EmpresaProductoResponseDTO response=new EmpresaProductoResponseDTO(ep.getIdUP(), ep.getProducto().getIdProducto(), ep.getCantidad(), ep.getPrecio(), ep.getEmpresa().getIdEmpresa());
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> actualizar(ActualizarEmpresaDTO datos, Long empresaID) {
		Optional<Empresa> empresaFound=empresaRep.findById(empresaID);
		if (!empresaFound.isPresent()) {
			return new ResponseEntity<>("empresa no encontrada o no registrada", HttpStatus.NOT_FOUND);
		}
		Empresa empresaBD=empresaFound.get();
		if (datos.getNomEmpresa()!=null) {
			empresaBD.setNomEmpresa(datos.getNomEmpresa());
		}
		
		if (datos.getNit()!=null) {
			empresaBD.setNIT(datos.getNit());
		}
		if (datos.getDireccion()!=null) {
			empresaBD.setDireccion(datos.getDireccion());
		}
		if (datos.getTelefono()!=null) {
			empresaBD.setTelefono(datos.getTelefono());
		}
		if (datos.getEmail()!=null) {
			empresaBD.setEmail(datos.getEmail());
		}
		if (datos.getWeb()!=null) {
			empresaBD.setWeb(datos.getWeb());
		}
		if (datos.getUsuarioID()!=null) {
			Optional<Usuario> usuarioFound=usuarioRep.findById(datos.getUsuarioID());
			if (!usuarioFound.isPresent()) {
				return new ResponseEntity<>("usuario no encontrado", HttpStatus.NOT_FOUND);
			}
			empresaBD.setUsuario(usuarioFound.get());
		}
		if (datos.getTipo()!=null) {
			Optional<TipoEmpresa> tipoFound=tipoEmpresaRep.findById(datos.getTipo());
			if (!tipoFound.isPresent()) {
				return new ResponseEntity<>("tipo de empresa no existente" ,HttpStatus.NOT_FOUND);
			}
			empresaBD.setTipo(tipoFound.get());
			
		}
		if (datos.getPaisID()!=null) {
			Optional<Pais> paisFound=paisRep.findById(datos.getPaisID());
			if (!paisFound.isPresent()) {
				return new ResponseEntity<>("pais no encontrado", HttpStatus.NOT_FOUND);
			}
			empresaBD.setPais(paisFound.get());
		}
		if (datos.getEstadoID()!=null) {
			Optional<Estado> estadoFound=estadoRep.findById(datos.getEstadoID());
			if (!estadoFound.isPresent()) {
				return new ResponseEntity<>("estado no encontrado", HttpStatus.NOT_FOUND);
			}
			empresaBD.setEstado(estadoFound.get());
		}
		if (datos.getCiudadID()!=null) {
			Optional<Ciudad> ciudadFound=ciudadRep.findById(datos.getCiudadID());
			if (!ciudadFound.isPresent()) {
				return new ResponseEntity<>("ciudad no encontrada", HttpStatus.NOT_FOUND);
			}
			empresaBD.setCiudad(ciudadFound.get());
		}
		Ciudad ciudad=ciudadRep.findById(empresaBD.getCiudad().getIdCiudad()).get();
		Estado estado=estadoRep.findById(empresaBD.getEstado().getIdEstado()).get();
		if (!(ciudad.getEstado()==empresaBD.getEstado() && estado.getPais()==empresaBD.getPais())) {
			return ResponseEntity.badRequest().body("la ciudad ingresada debe pertenecer al estado ingresado, y el estado ingresado debe pertenecer al país ingresado");
		}
		empresaRep.save(empresaBD);
		EmpresaResponseDTO response=new EmpresaResponseDTO(empresaBD.getIdEmpresa(), empresaBD.getNomEmpresa(), empresaBD.getNIT(), empresaBD.getDireccion(), empresaBD.getTelefono(), empresaBD.getEmail(), empresaBD.getWeb(), empresaBD.getUsuario().getId(), empresaBD.getTipo().getTipo(), empresaBD.getPais().getNomPais(), empresaBD.getEstado().getNomEstado(), empresaBD.getCiudad().getNomCiudad());
		return ResponseEntity.ok(response);
	}

	

}
