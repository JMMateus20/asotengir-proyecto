package com.asotengir.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asotengir.model.Categorias;
import com.asotengir.model.Marcas;

public interface MarcaRepository extends JpaRepository<Marcas, Long>{
	
	Optional<Marcas> findByNomMarca(String nombre);
	
	
	Optional<Marcas> findByCategorias(Categorias categoria);
	
	
	@Query("SELECT M FROM Marcas AS M WHERE M.nomMarca=:nomMarca AND M.categorias.idCategoria=:categoriaID")
	Optional<Marcas> findByNomMarcaPorCategoriaID(@Param(value = "nomMarca") String nomMarca, @Param(value = "categoriaID") Long categoriaID);

	
	
}
