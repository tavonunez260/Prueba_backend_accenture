package com.accenture.pruebabackend.demo.request;

public class FacturaDelete {
	
	private Integer idFactura;
	private String fechaEliminacion;
	
	public FacturaDelete(Integer idFactura, String fechaEliminacion) {
		this.idFactura = idFactura;
		this.fechaEliminacion = fechaEliminacion;
	}
	public FacturaDelete() {

	}

	public Integer getIdFactura() {
		return idFactura;
	}
	public String getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public void setFechaEliminacion(String fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}	
}
