package com.ludoteca.arkham.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "correo", length = 60, nullable = false, unique=true)
	private String correo;
	@Column(name = "contrasenia", length = 30, nullable = false)
	private String contrasenia;
	@Column(name = "nombre_usuario", length = 60, nullable = false, unique=true)
	private String nombreUsuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Usuario() {
		
	}
	public Usuario(int id, String correo, String contrasenia, String nombreUsuario) {
		super();
		this.id = id;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.nombreUsuario = nombreUsuario;
	}
}
