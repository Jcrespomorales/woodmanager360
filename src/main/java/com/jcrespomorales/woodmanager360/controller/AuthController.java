package com.jcrespomorales.woodmanager360.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jcrespomorales.woodmanager360.dto.RegistroUsuarioDTO;
import com.jcrespomorales.woodmanager360.entity.Usuario;
import com.jcrespomorales.woodmanager360.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(
            @RequestBody RegistroUsuarioDTO dto) {

        Usuario usuario = usuarioService.registrarUsuario(dto);

        return ResponseEntity.ok(usuario);
    }
}