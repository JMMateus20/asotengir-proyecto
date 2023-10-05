package com.asotengir.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asotengir.dao.EmpresaProductoJoinDTO;
import com.asotengir.dao.EmpresaProductoJoinDTO2;
import com.asotengir.model.EmpresaProducto;

public interface EmpresaProductoRepository extends JpaRepository<EmpresaProducto, Long>{
	
	
	@Query("SELECT new com.asotengir.dao.EmpresaProductoJoinDTO(e.idUP,p.nomProducto,p.descripcion,p.modelo,m.nomMarca,c.nomCategoria,p.baseView,e.cantidad,e.precio,e.stockItems,e.calificacion) " 
			+ "FROM EmpresaProducto e INNER JOIN e.producto p LEFT JOIN e.producto.marca m INNER JOIN e.producto.categoria c WHERE e.empresa.nomEmpresa=:nomEmpresa ORDER BY p.nomProducto ASC")
	List<EmpresaProductoJoinDTO> listarPorEmpresa(@Param(value = "nomEmpresa") String nomEmpresa);
	

	@Query("SELECT new com.asotengir.dao.EmpresaProductoJoinDTO2(e.idUP,s.nomEmpresa,h.nomPais,i.nomEstado,j.nomCiudad ,p.nomProducto,p.descripcion,p.modelo,m.nomMarca,c.nomCategoria,p.baseView,e.cantidad,e.precio,e.stockItems,e.calificacion) " 
			+ "FROM EmpresaProducto e INNER JOIN e.empresa s INNER JOIN e.empresa.pais h INNER JOIN e.empresa.estado i INNER JOIN e.empresa.ciudad j INNER JOIN e.producto p LEFT JOIN e.producto.marca m INNER JOIN e.producto.categoria c WHERE e.empresa.pais.nomPais=:nomPais OR e.empresa.estado.nomEstado=:nomEstado OR e.empresa.ciudad.nomCiudad=:nomCiudad ORDER BY s.nomEmpresa ASC")
	List<EmpresaProductoJoinDTO2> listarPorLocacion(@Param(value = "nomPais") String nomPais, @Param(value = "nomEstado") String nomEstado, @Param(value = "nomCiudad") String nomCiudad);
	
}
