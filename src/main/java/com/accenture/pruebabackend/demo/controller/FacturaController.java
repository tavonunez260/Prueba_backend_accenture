package com.accenture.pruebabackend.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pruebabackend.demo.model.Factura;
import com.accenture.pruebabackend.demo.request.FacturaDelete;
import com.accenture.pruebabackend.demo.request.FacturaEdit;
import com.accenture.pruebabackend.demo.request.FacturaRequest;
import com.accenture.pruebabackend.demo.services.FacturaService;

import io.swagger.annotations.ApiOperation;

@RestController
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	@ApiOperation(value = "Crea una factura", 
			notes = "none")
	@PostMapping (value = "/factura")
	private ResponseEntity<Factura> create(@RequestBody FacturaRequest compra) {
		Factura fac = facturaService.save(compra);
		return new ResponseEntity<Factura>(fac, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Edita una factura", 
			notes = "none")
	@PutMapping (value = "/factura/id")
	private ResponseEntity<Factura> create(@RequestBody FacturaEdit edicion) {
		Factura fac = facturaService.edit(edicion);
		if(fac != null) {
			return new ResponseEntity<Factura>(fac, HttpStatus.OK);
		} else {
			return new ResponseEntity<Factura>(fac, HttpStatus.UNAUTHORIZED);
		}		
	}
	
	@ApiOperation(value = "Elimina factura", 
			notes = "none")
	@DeleteMapping (value = "/factura/id")
	private ResponseEntity<Factura> delete(@RequestBody FacturaDelete eliminar) {
		Factura fac = facturaService.delete(eliminar);
		if(fac != null) {
			return new ResponseEntity<Factura>(fac, HttpStatus.OK);
		} else {
			return new ResponseEntity<Factura>(fac, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@ApiOperation(value = "Obtiene todas las facturas", 
			notes = "none")
	@GetMapping (value = "/facturas/")
	private ResponseEntity<ArrayList<Factura>> get() {
		ArrayList<Factura> facturas = facturaService.get();
		if(facturas != null) {
			return new ResponseEntity<ArrayList<Factura>>(facturas, HttpStatus.OK);
		} else {
			return new ResponseEntity<ArrayList<Factura>>(facturas, HttpStatus.UNAUTHORIZED);
		}
	}
}
