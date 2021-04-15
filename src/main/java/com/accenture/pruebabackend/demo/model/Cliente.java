package com.accenture.pruebabackend.demo.model;


public class Cliente {
	
	private String nombre;
	private String cedula;
	private String direccion;
	
	public Cliente() {

	}
	public Cliente(String cedula, String nombre, String direccion) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
	}
	
	public String getCedula() {
		return cedula;
	}
}
