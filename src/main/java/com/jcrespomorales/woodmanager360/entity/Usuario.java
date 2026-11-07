package com.jcrespomorales.woodmanager360.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String nombre;

	@Column(nullable = false, length = 150)
	private String apellidos;

	@Column(nullable = false, length = 150)
	private String email;

	@Column(nullable = false, length = 250)
	private String contrasena;

	@Column(nullable = true, length = 20)
	private String telefono;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Rol rol = Rol.USUARIO;

	@Column(name = "fecha_registro", nullable = false)
	private LocalDateTime fechaRegistro;

	@Column(nullable = false)
	private Boolean activo = true;

}