package com.asotengir.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asotengir.model.Categorias;

public interface CategoriaRepository extends JpaRepository<Categorias, Long>{

	Optional<Categorias> findByNomCategoria(String nombre);
}
