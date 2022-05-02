//CLASE JUEGO CREADA POR JOAN SALAS 27/04
package com.ludoteca.arkham.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Estereotipos -> @Entity @Autowired @Table, etc
@Entity
//Table sirve para indicar el nombre de la tabla en la BD
@Table(name = "juegos")
public class Juego {
	// CREACION DE ATRIBUTOS DE LA CLASE

	// Id significa que estamos asignando una ID de la tabla
	@Id
	// Genera los valores de manera automatica como autoincrements
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private int precio;
	
	@Column(name="edicion",length = 50,nullable = false)
	private String edicion;

	// CREACION DE CONSTRUCTORES (VACIO Y CON SUS ATRIBUTOS)
	public Juego() {

	}

	public Juego(int id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	// GETTERS Y SETTERS
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

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	

}
