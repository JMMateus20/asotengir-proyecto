package com.asotengir.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asotengir.dao.ActualizarProductoDTO;
import com.asotengir.dao.ProductoDTO;
import com.asotengir.dao.RegistroProductoDTO;
import com.asotengir.model.Categorias;
import com.asotengir.model.Marcas;
import com.asotengir.model.Productos;
import com.asotengir.respository.CategoriaRepository;
import com.asotengir.respository.MarcaRepository;
import com.asotengir.respository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRep;
	
	@Autowired
	private MarcaRepository marcaRep;

	@Autowired
	private CategoriaRepository categoriaRep;
	
	@Override
	public ResponseEntity<?> insertar(RegistroProductoDTO datos) {
		Optional<Categorias> categoriaFound=categoriaRep.findById(datos.getCategoria());
		if (!categoriaFound.isPresent()) {
			return ResponseEntity.badRequest().body("categoria no encontrada");
		}
		Categorias categoriaBD=categoriaFound.get();
		Marcas marcaBD=null;
		if (datos.getMarca()!=null) {
			Optional<Marcas> marcaFound=marcaRep.findById(datos.getMarca());
			if (!marcaFound.isPresent()) {
				return ResponseEntity.badRequest().body("marca no encontrada");
			}
			marcaBD=marcaFound.get();
			if (marcaBD.getCategorias()!=categoriaBD) {
				return ResponseEntity.badRequest().body("La marca no pertenece a la categoria asociada");
			}
		}
		
		
		Optional<Productos> productoYaExistente=productoRep.findByNomProducto(datos.getNomProducto());
		if (productoYaExistente.isPresent()) {
			return ResponseEntity.badRequest().body("producto ya existente en la base de datos");
		}
		Productos productoNuevo=new Productos(datos.getNomProducto(), datos.getDescripcion(), datos.getModelo(), marcaBD, categoriaBD, datos.getBaseView());
		productoRep.save(productoNuevo);
		return ResponseEntity.ok("producto insertado");
		
	}

	@Override
	public List<ProductoDTO> listarJoin() {
		List<ProductoDTO> response= productoRep.listarJoin();
		if (response.isEmpty()) {
			return new ArrayList<>();
		}
		for (ProductoDTO registro:response) {
			if (registro.getNomMarca()==null) {
				registro.setNomMarca("Sin marca");
			}
		}
		return response;
	}

	@Override
	public ResponseEntity<?> modificar(Long idProducto, ActualizarProductoDTO datos) {
		Optional<Productos> productoFound=productoRep.findById(idProducto);
		if (!productoFound.isPresent()) {
			return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
		}
		Productos productoBD=productoFound.get();
		if (datos.getNomProducto()!=null) {
			productoBD.setNomProducto(datos.getNomProducto());
		}
		if (datos.getDescripcion()!=null) {
			productoBD.setDescripcion(datos.getDescripcion());
		}
		if (datos.getModelo()!=null) {
			productoBD.setModelo(datos.getModelo());
		}
		
		
		if (datos.getNomCategoria()!=null) {
			Optional<Categorias> categoriaFound=categoriaRep.findByNomCategoria(datos.getNomCategoria());
			if (!categoriaFound.isPresent()) {
				return new ResponseEntity<>("categoria no encontrada o no registrada", HttpStatus.NOT_FOUND);
			}
			productoBD.setCategoria(categoriaFound.get());
			if (productoBD.getMarca()!=null) {
				if (productoBD.getMarca().getCategorias()!=productoBD.getCategoria()) {
					if (datos.getNomMarca()==null) {
						return ResponseEntity.badRequest().body("la marca debe pertenecer a la categoria especificada.");
					}else {
						Optional<Marcas> marcaFound=marcaRep.findByNomMarca(datos.getNomMarca());
						if (!marcaFound.isPresent()) {
							return new ResponseEntity<>("marca no encontrada o no registrada", HttpStatus.NOT_FOUND);
						}
						if (productoBD.getCategoria()==marcaFound.get().getCategorias()) {
							productoBD.setMarca(marcaFound.get());
						}else {
							return ResponseEntity.badRequest().body("la marca debe pertenecer a la categoria especificada.");
						}
					}
					
				}
			}
		}
		
		if (datos.getNomMarca()!=null) {
			Optional<Marcas> marcaFound=marcaRep.findByNomMarca(datos.getNomMarca());
			if (!marcaFound.isPresent()) {
				return new ResponseEntity<>("marca no encontrada o no registrada", HttpStatus.NOT_FOUND);
			}
			productoBD.setMarca(marcaFound.get());
			if (productoBD.getMarca().getCategorias()!=productoBD.getCategoria()) {
				return ResponseEntity.badRequest().body("la marca debe pertenecer a la categoria especificada.");
			}
		}
		if (datos.getBaseView()!=null) {
			productoBD.setBaseView(datos.getBaseView());
		}
		productoRep.save(productoBD);
		ActualizarProductoDTO response=null;
		if (productoBD.getMarca()==null) {
			response=new ActualizarProductoDTO(productoBD.getNomProducto(), productoBD.getDescripcion(), productoBD.getModelo(), null, productoBD.getCategoria().getNomCategoria(), productoBD.getBaseView());
		}else {
			response=new ActualizarProductoDTO(productoBD.getNomProducto(), productoBD.getDescripcion(), productoBD.getModelo(), productoBD.getMarca().getNomMarca(), productoBD.getCategoria().getNomCategoria(), productoBD.getBaseView());
		}
		
		return ResponseEntity.ok(response);
		
		
	}

	@Override
	public ResponseEntity<?> encontrarPorCategoria(Long idCategoria) {
		Optional<Categorias> categoriaFound=categoriaRep.findById(idCategoria);
		if (!categoriaFound.isPresent()) {
			return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
		}
		List<ProductoDTO> productos=productoRep.findByCategoria(categoriaFound.get()).stream()
				.map(producto->{
					ProductoDTO resp=new ProductoDTO(producto.getIdProducto(), producto.getNomProducto(), (producto.getDescripcion()!=null) ? producto.getDescripcion():"sin descripcion" , (producto.getModelo()!=null)?producto.getModelo():"Sin modelo", (producto.getMarca()!=null)?producto.getMarca().getNomMarca():"sin marca", producto.getCategoria().getNomCategoria(), (producto.getBaseView()!=null)?producto.getBaseView():"xxx", (producto.getMarca()!=null)?producto.getMarca().getIdMarca():null,producto.getCategoria().getIdCategoria());
					return resp;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(productos);
	}

	@Override
	public ResponseEntity<?> encontrarPorMarca(Long idMarca) {
		Optional<Marcas> marcaFound=marcaRep.findById(idMarca);
		if (!marcaFound.isPresent()) {
			return new ResponseEntity<>("marca no encontrada", HttpStatus.NOT_FOUND);
		}
		List<ProductoDTO> productos=productoRep.findByMarca(marcaFound.get()).stream()
				.map(producto->{
					ProductoDTO resp=new ProductoDTO(producto.getIdProducto(), producto.getNomProducto(), (producto.getDescripcion()!=null)?producto.getDescripcion():"sin descripcion", (producto.getModelo()!=null)?producto.getModelo():"sin modelo", producto.getMarca().getNomMarca(), producto.getCategoria().getNomCategoria(), (producto.getBaseView()!=null)?producto.getBaseView():"xxx", producto.getMarca().getIdMarca(), producto.getCategoria().getIdCategoria());
					return resp;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(productos);
	}

	@Override
	public ResponseEntity<?> filtrarPorCategoriaOMarca(Long idCategoria, Long idMarca) {
		Categorias categoriaBD=null;
		Marcas marcaBD=null;
		if (idCategoria!=null) {
			Optional<Categorias> categoriaFound=categoriaRep.findById(idCategoria);
			if (!categoriaFound.isPresent()) {
				return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
			}
			categoriaBD=categoriaFound.get();
		}
		if (idMarca!=null) {
			Optional<Marcas> marcaFound=marcaRep.findById(idMarca);
			if (!marcaFound.isPresent()) {
				return new ResponseEntity<>("marca no encontrada", HttpStatus.NOT_FOUND);
			}
			marcaBD=marcaFound.get();
		}
		
		List<ProductoDTO> productos=productoRep.findByCategoriaOrMarca(categoriaBD, marcaBD)
				.stream().map(prod->{
					ProductoDTO resp=new ProductoDTO(prod.getIdProducto(), prod.getNomProducto(), (prod.getDescripcion()!=null)?prod.getDescripcion():"sin descripcion", (prod.getModelo()!=null)?prod.getModelo():"sin modelo", (prod.getMarca()!=null)?prod.getMarca().getNomMarca():"sin marca", prod.getCategoria().getNomCategoria(), (prod.getBaseView()!=null)?prod.getBaseView():"xxx", (prod.getMarca()!=null)?prod.getMarca().getIdMarca():null, prod.getCategoria().getIdCategoria());
					return resp;
				}).collect(Collectors.toList());
		return ResponseEntity.ok(productos);
	}

}
