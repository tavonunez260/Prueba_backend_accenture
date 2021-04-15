package com.accenture.pruebabackend.demo.request;

public class ClienteRequest {
	private Integer idCliente;
	private String nombre;
	private String cedula;
	private String direccion;
	
	public ClienteRequest(Integer idCliente, String nombre, String cedula, String direccion) {
		//super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
	}
	public ClienteRequest() {
		
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
	
	@Override
	public String toString() {
		return "ClienteRequest [idCliente=" + idCliente + ", nombre=" + nombre + ", cedula=" + cedula + ", direccion="
				+ direccion + "]";
	}
}
