package com.accenture.pruebabackend.demo.request;

public class ProductoRequest {
	private Integer idProducto;	
	
	public ProductoRequest(Integer idProducto) {
		//super();
		this.idProducto = idProducto;
	}
	public ProductoRequest() {
		//super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	

	@Override
	public String toString() {
		return "ProductoRequest{" +
				"idProducto=" + idProducto +
				'}';
	}
}
