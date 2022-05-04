package com.ludoteca.arkham.modelo;

import javax.persistence.*;

//Autor: Joan Salas 04/05
@Entity
@Table(name = "expansiones")
public class Expansion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "precio", nullable = false)
	private int precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Expansion(int id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Expansion() {
		super();
	}

	
	
}
