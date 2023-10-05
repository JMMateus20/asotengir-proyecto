package com.asotengir.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asotengir.dao.EmpresaDTO;
import com.asotengir.dao.EmpresaProductoJoinDTO3;
import com.asotengir.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	
	
	@Query("SELECT new com.asotengir.dao.EmpresaDTO(e.idEmpresa,e.nomEmpresa,e.NIT,e.direccion,e.telefono,e.email,e.web,u.nombreUsuario, t.tipo, p.nomPais, s.nomEstado, c.nomCiudad, u.usuarioID, t.idTipo, p.idPais, s.idEstado, c.idCiudad) "
			+ "FROM Empresa e INNER JOIN e.usuario u INNER JOIN e.tipo t INNER JOIN e.pais p INNER JOIN e.estado s INNER JOIN e.ciudad c order by e.nomEmpresa ASC")
	List<EmpresaDTO> listarEmpresas();
	
	
	@Query("SELECT E FROM Empresa AS E WHERE E.nomEmpresa=:nombre")
	Optional<Empresa> findByNomEmpresa(@Param(value = "nombre") String nombre);
	
	
	@Query("SELECT new com.asotengir.dao.EmpresaProductoJoinDTO3(e.nomEmpresa, e.pais.nomPais, e.estado.nomEstado, e.ciudad.nomCiudad) " 
			+ "FROM Empresa e WHERE e.usuario.usuarioID=:usuarioID")
	List<EmpresaProductoJoinDTO3> listarPorUsuario(@Param(value = "usuarioID") Long usuarioID);
	
	
	

}
