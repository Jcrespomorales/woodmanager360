package com.jcrespomorales.woodmanager360.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jcrespomorales.woodmanager360.dto.RegistroUsuarioDTO;
import com.jcrespomorales.woodmanager360.entity.Usuario;
import com.jcrespomorales.woodmanager360.service.UsuarioService;
import com.jcrespomorales.woodmanager360.dto.LoginUsuarioDTO;

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
    
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(
            @RequestBody LoginUsuarioDTO dto) {

        Usuario usuario = usuarioService.login(
                dto.getEmail(),
                dto.getPassword());

        return ResponseEntity.ok(usuario);
    }
}