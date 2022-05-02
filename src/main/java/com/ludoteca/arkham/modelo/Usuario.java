package com.ludoteca.arkham.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	@Column(name = "clave", nullable = false)
	private String clave;
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
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Usuario(int id, String correo, String clave) {
		super();
		this.id = id;
		this.correo = correo;
		this.clave = clave;
	}
	
	public Usuario() {
		
	}
	
}
