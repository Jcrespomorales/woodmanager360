package com.jcrespomorales.woodmanager360.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jcrespomorales.woodmanager360.dto.RegistroUsuarioDTO;
import com.jcrespomorales.woodmanager360.entity.Rol;
import com.jcrespomorales.woodmanager360.entity.Usuario;
import com.jcrespomorales.woodmanager360.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	// ==============================
	// ===== Registrar usuario ======
	// ==============================

	public Usuario registrarUsuario(RegistroUsuarioDTO dto) {

		if (usuarioRepository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("El email ya existe");
		}

		Usuario usuario = new Usuario();

		usuario.setNombre(dto.getNombre());
		usuario.setApellidos(dto.getApellidos());
		usuario.setEmail(dto.getEmail());
		usuario.setPassword(dto.getPassword());
		usuario.setTelefono(dto.getTelefono());

		usuario.setRol(Rol.USUARIO);

		usuario.setFechaRegistro(LocalDateTime.now());

		usuario.setActivo(true);

		return usuarioRepository.save(usuario);

	}
	
	
    //==============================
    //======= Login usuario ========
    //==============================
	public Usuario login(String email, String password) {

	    Usuario usuario = usuarioRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

	    if (!usuario.getPassword().equals(password)) {
	        throw new RuntimeException("Contraseña incorrecta");
	    }

	    return usuario;
	}
	
}