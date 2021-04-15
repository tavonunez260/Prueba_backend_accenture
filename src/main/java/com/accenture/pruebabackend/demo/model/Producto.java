package com.accenture.pruebabackend.demo.model;

public class Producto {
	private Integer idProducto;
	private String nombre;
	private Double precio;

	public Producto(Integer idProducto, String nombre, Double precio) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPrecio() {
		return precio;
	}
}
