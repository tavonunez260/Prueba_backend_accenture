package com.accenture.pruebabackend.demo.request;

import java.util.ArrayList;

public class FacturaRequest {
	private Integer idFactura;
	private String idCliente;
    private ArrayList<Integer> listaIDProductos;
    private String fechaCreacion;
    
	public FacturaRequest(String idCliente, Integer idFactura, ArrayList<Integer> listaIDProductos, String fechaCreacion) {
		this.idCliente = idCliente;
		this.setIdFactura(idFactura);
		this.listaIDProductos = listaIDProductos;
		this.fechaCreacion = fechaCreacion;
	}
	public FacturaRequest() {

	}

	public String getIdCliente() {
		return idCliente;
	}
	public ArrayList<Integer> getListaIDProductos() {
		return listaIDProductos;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public void setListaIDProductos(ArrayList<Integer> listaIDProductos) {
		this.listaIDProductos = listaIDProductos;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}	
}
