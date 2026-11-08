package com.jcrespomorales.woodmanager360.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcrespomorales.woodmanager360.entity.Usuario;

public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// Recupera un usuario por email encapsulando ausencia/presencia con Optional.
	Optional<Usuario> findByEmail(String email);
	
	// Comprueba si ya existe un usuario con ese email para validar unicidad.
	boolean existsByEmail(String email);
}