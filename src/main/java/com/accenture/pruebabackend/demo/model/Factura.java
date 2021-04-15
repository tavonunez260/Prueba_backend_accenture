package com.accenture.pruebabackend.demo.model;

import java.util.ArrayList;

public class Factura {
	private Integer idFactura;
	private Cliente cliente;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();	
	private String fechaCreacion;
	private Double subtotal;
	private Double total;
	private boolean estado = true;
	
	public Factura() {

	}
	
	public Integer getIdFactura() {
		return idFactura;
	}	
	public void agregarProducto(Producto producto) {
		listaProductos.add(producto);
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public Double getTotal() {
		return total;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}


