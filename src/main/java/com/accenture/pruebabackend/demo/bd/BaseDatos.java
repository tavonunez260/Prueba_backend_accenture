package com.accenture.pruebabackend.demo.bd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedroatencio
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedroatencio
 */

import java.util.ArrayList;
import java.util.Iterator;

import com.accenture.pruebabackend.demo.model.Cliente;
import com.accenture.pruebabackend.demo.model.Factura;
import com.accenture.pruebabackend.demo.model.Producto;

public class BaseDatos {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Factura> facturas;

    public BaseDatos() {
        this.clientes = new ArrayList<Cliente>();
        this.productos = new ArrayList<Producto>();
        this.facturas = new ArrayList<Factura>();

        this.clientes.add(new Cliente("1082828", "Juan Perez", "Calle ABCD"));
        this.clientes.add(new Cliente("778778", "Julio Sanchez", "Calle BCDA"));
        this.clientes.add(new Cliente("685859", "Camila Gomez", "Calle ACDB"));
        
        this.productos.add(new Producto(111, "Detergente", 2500.00));
        this.productos.add(new Producto(112, "Enlatado", 5000.00));
        this.productos.add(new Producto(113, "Televisor", 1000000.00));
        this.productos.add(new Producto(114, "Dell Inspiron 3593", 31500.00));
        this.productos.add(new Producto(115, "Sony NW-A105", 12000.00));
        this.productos.add(new Producto(116, "Xiaomi Redmi Note 8 Pro", 9000.00));
        this.productos.add(new Producto(117, "GoPro Hero Black 9", 20000.00));
    }
    
    public Cliente selectClienteByCedula(String cedula){
        Iterator<Cliente> clienteIterator = this.clientes.iterator();
        while(clienteIterator.hasNext()){
            Cliente cliente = clienteIterator.next();
            if(cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }
    
    public ArrayList<Producto> selectProductosByIds(ArrayList<Integer> ids){
        ArrayList<Producto> productosSeleccionados = new ArrayList<Producto>();
        Iterator<Producto> productosIterator = this.productos.iterator();
        while(productosIterator.hasNext()){
            Producto temp = productosIterator.next();   
            if(ids.contains(temp.getIdProducto())){
                productosSeleccionados.add(temp);
            }
        }
        return productosSeleccionados;
    }
    
    public void agregarFactura(Factura factura) {
    	facturas.add(factura);
    }
    
    public Factura selectFacturaById(Integer idFactura) {
    	Factura tmp = null;
    	for (Factura factura: facturas) {
    		tmp = factura;
    		if(factura.getIdFactura().equals(idFactura)) {
    			return tmp;
    		}
    	}
    	return tmp;
    }
    
    public void agregarProductosAFactura(Integer idFactura, ArrayList<Producto> itemsAgregar) {
    	Factura facturaEncontrada = selectFacturaById(idFactura);
    	facturaEncontrada.getListaProductos().addAll(itemsAgregar);
    }
    
    public Factura eliminarFactura (Integer idFactura) {
    	Factura facturaEncontrada = selectFacturaById(idFactura);
    	facturas.remove(facturaEncontrada);
    	return facturaEncontrada;
    }
    
    public ArrayList<Factura> obtenerFacturas() {
    	return facturas;
    }
}