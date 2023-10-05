package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asotengir.dao.ProductoDTO;
import com.asotengir.model.Productos;


public interface ProductoRepository extends JpaRepository<Productos,Long> {

	Optional<Productos> findByNomProducto(String nombre);
	
	
	@Query("SELECT new com.asotengir.dao.ProductoDTO(p.idProducto, p.nomProducto, p.descripcion, p.modelo, m.nomMarca, c.nomCategoria, p.baseView, m.idMarca, c.idCategoria) "
			+ "FROM Productos p LEFT JOIN p.marca m INNER JOIN p.categoria c order by p.nomProducto ASC")
	List<ProductoDTO> listarJoin();

	
	
	
	
}
