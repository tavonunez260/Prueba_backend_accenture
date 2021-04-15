package com.accenture.pruebabackend.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.accenture.pruebabackend.demo.bd.BaseDatos;
import com.accenture.pruebabackend.demo.model.Cliente;
import com.accenture.pruebabackend.demo.model.Factura;
import com.accenture.pruebabackend.demo.model.Producto;
import com.accenture.pruebabackend.demo.request.FacturaDelete;
import com.accenture.pruebabackend.demo.request.FacturaEdit;
import com.accenture.pruebabackend.demo.request.FacturaRequest;

@Service
public class FacturaService {
	BaseDatos baseDeDatos = new BaseDatos();
	Double precioDomicilio = 10000.00;
	
	public Factura save(FacturaRequest facturaRequest) {
		Cliente clienteEncontrado = baseDeDatos.selectClienteByCedula(facturaRequest.getIdCliente());
		ArrayList<Producto> productosComprados = baseDeDatos.selectProductosByIds(facturaRequest.getListaIDProductos());
		
		//Creacion de factura
		Factura facturaResponse = new Factura();
		
		//Inicialización de atributos
		facturaResponse.setListaProductos(productosComprados);
		facturaResponse.setCliente(clienteEncontrado);
		facturaResponse.setFechaCreacion(facturaRequest.getFechaCreacion());
		
		//Inicialización de costos de factura
		Double subtotal = 0.0;
		Double total = 0.0;
		
		Producto tmp = null;
		for(int i = 0; i < facturaResponse.getListaProductos().size(); i++) {
			tmp = facturaResponse.getListaProductos().get(i);
			subtotal += tmp.getPrecio();
		}
		if(subtotal < 70000.00) {
			total = subtotal + precioDomicilio;
			System.out.println("Costo de productos a comprar con un valor menor a 70000, no se cobrará IVA");
		} else if (subtotal >= 70000.00 && subtotal < 100000.00) {
			total = subtotal * 1.19 + precioDomicilio;
			System.out.println("Costo de productos a comprar con un valor entre 70000 y 100000");
			System.out.println("Se cobrará IVA de productos y domicilio");
		} else {
			total = subtotal * 1.19;
			System.out.println("Costo de productos a comprar con un valor mayor a 10000");
			System.out.println("Sólo se cobrará IVA, domicilio gratis");
			
		}		
		facturaResponse.setSubtotal(subtotal);
		facturaResponse.setTotal(total);
		System.out.println("Pedido creado exitosamente");
		
		//Inicialización de ID
		facturaResponse.setIdFactura(facturaRequest.getIdFactura());
		
		baseDeDatos.agregarFactura(facturaResponse);
		
		return facturaResponse;
	}

	public ArrayList<Factura> get() {
		return baseDeDatos.obtenerFacturas();
	}
	
	public Factura edit(FacturaEdit facturaEdit){
		Factura facturaEncontrada = baseDeDatos.selectFacturaById(facturaEdit.getIdFactura());
		
		//Formato de fechas
		LocalDateTime fechaCreacionFactura = LocalDateTime.parse(facturaEncontrada.getFechaCreacion());
		LocalDateTime fechaModificacionFactura = LocalDateTime.parse(facturaEdit.getFechaModificacion());
		
		if(fechaModificacionFactura.getHour() - fechaCreacionFactura.getHour() <= 5) {
			Double subTotalAdd = 0.0;
			//Double total = 0.0;
			ArrayList<Producto> productosAdd = baseDeDatos.selectProductosByIds(facturaEdit.getListaIDProductosAgregar());
			Producto tmp = null;
			for(int i = 0; i < productosAdd.size(); i++) {
				tmp = productosAdd.get(i);
				subTotalAdd += tmp.getPrecio();
			}
			if(subTotalAdd >= facturaEncontrada.getSubtotal()) {
				baseDeDatos.agregarProductosAFactura(facturaEncontrada.getIdFactura(), productosAdd);
				
				Double subtotalNuevo = facturaEncontrada.getSubtotal() + subTotalAdd;
				Double totalNuevo = 0.0;
				
				if(subtotalNuevo < 70000.00) {
					totalNuevo = subtotalNuevo + precioDomicilio;
					System.out.println("Costo actualizado de productos a comprar con un valor menor a 70000, no se cobrará IVA");
				} else if (subtotalNuevo >= 70000.00 && subtotalNuevo < 100000.00) {
					totalNuevo = subtotalNuevo * 1.19 + precioDomicilio;
					System.out.println("Costo actualizado de productos a comprar con un valor entre 70000 y 100000");
					System.out.println("Se cobrará IVA de productos y domicilio");
				} else {
					totalNuevo = subtotalNuevo * 1.19;
					System.out.println("Costo actualizado de productos a comprar con un valor mayor a 10000");
					System.out.println("Sólo se cobrará IVA, domicilio gratis");
				}		
				facturaEncontrada.setSubtotal(subtotalNuevo);
				facturaEncontrada.setTotal(totalNuevo);
				System.out.println("Pedido actualizado exitosamente");
				
				
				return baseDeDatos.selectFacturaById(facturaEdit.getIdFactura());
			} else {
				System.out.println("No se puede editar el pedido número " + facturaEncontrada.getIdFactura());
				System.out.println("El costo de los productos a agregar es menor que el costo de los productos en la canasta");
				return null;
			}
		} else {
			System.out.println("No se puede editar el pedido número " + facturaEncontrada.getIdFactura());
			System.out.println("Han pasado más de cinco horas desde la creación del pedido");
			return null;
		}
	}

	public Factura delete(FacturaDelete facturaDelete) {
		Factura facturaEncontrada = baseDeDatos.selectFacturaById(facturaDelete.getIdFactura());
		
		//Formato de fechas
		LocalDateTime fechaCreacionFactura = LocalDateTime.parse(facturaEncontrada.getFechaCreacion());
		LocalDateTime fechaEliminacionFactura = LocalDateTime.parse(facturaDelete.getFechaEliminacion());
		
		if(fechaEliminacionFactura.getHour() - fechaCreacionFactura.getHour() <= 12) { 
			facturaEncontrada.setEstado(false);
			baseDeDatos.eliminarFactura(facturaEncontrada.getIdFactura());
			System.out.println("Pedido número " + facturaEncontrada.getIdFactura() + " eliminado exitosamente");
			return facturaEncontrada;
		} else {
			facturaEncontrada.setEstado(false);
			facturaEncontrada.setTotal(facturaEncontrada.getTotal() * 1.1);
			System.out.println("No se puede eliminar el pedido número " + facturaEncontrada.getIdFactura());
			System.out.println("Han pasado más de 12 horas desde la creación del pedido");
			System.out.println("Se cobrará el 10% del valor del pedido y se cancelará el pedido");
			System.out.println("Es decir, pagará "+ facturaEncontrada.getTotal());
			return facturaEncontrada;
		}		
	}
}
