package com.asotengir.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asotengir.dao.ComentariosResponseDTO;
import com.asotengir.model.Comentarios;

public interface ComentarioRepository extends JpaRepository<Comentarios, Long>{
	
	@Query("SELECT new com.asotengir.dao.ComentariosResponseDTO(c.comentario) "
			+ "FROM Comentarios c WHERE c.producto.idUP=:idUP")
	List<ComentariosResponseDTO> comentariosPorRegistro(@Param(value = "idUP") Long idUP);

}
