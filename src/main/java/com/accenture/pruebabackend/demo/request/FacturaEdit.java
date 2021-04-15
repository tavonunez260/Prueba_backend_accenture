package com.accenture.pruebabackend.demo.request;

import java.util.ArrayList;

public class FacturaEdit {
	private Integer idFactura;
    private ArrayList<Integer> listaIDProductosAgregar;
    private String fechaModificacion;
    
	
	public FacturaEdit(Integer idFactura, ArrayList<Integer> listaIDProductosAgregar, String fechaModificacion) {
		this.idFactura = idFactura;
		this.listaIDProductosAgregar = listaIDProductosAgregar;
		this.fechaModificacion = fechaModificacion;
	}	
	public FacturaEdit() {

	}

	public Integer getIdFactura() {
		return idFactura;
	}
	public ArrayList<Integer> getListaIDProductosAgregar() {
		return listaIDProductosAgregar;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public void setListaIDProductosAgregar(ArrayList<Integer> listaIDProductosAgregar) {
		this.listaIDProductosAgregar = listaIDProductosAgregar;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
}
