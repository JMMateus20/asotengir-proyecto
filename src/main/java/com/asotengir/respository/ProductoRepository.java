package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.asotengir.dao.ProductoDTO;
import com.asotengir.model.Categorias;
import com.asotengir.model.Marcas;
import com.asotengir.model.Productos;


public interface ProductoRepository extends JpaRepository<Productos,Long> {

	Optional<Productos> findByNomProducto(String nombre);
	
	
	@Query("SELECT new com.asotengir.dao.ProductoDTO(p.idProducto, p.nomProducto, p.descripcion, p.modelo, m.nomMarca, c.nomCategoria, p.baseView, m.idMarca, c.idCategoria) "
			+ "FROM Productos p LEFT JOIN p.marca m INNER JOIN p.categoria c order by p.nomProducto ASC")
	List<ProductoDTO> listarJoin();
	
	
	
	List<Productos> findByCategoria(Categorias categoria);
	
	
	List<Productos> findByMarca(Marcas marca);
	
	@Query("SELECT P FROM Productos AS P WHERE P.categoria=:categoria OR P.marca=:marca")
	List<Productos> findByCategoriaOrMarca(@Param(value = "categoria") Categorias categoria, @Param(value = "marca") Marcas marca);

	
	
	
	
}
