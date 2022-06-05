/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.products.sbpg.service;

import java.util.List;

import com.products.sbpg.dto.ProductDTO;
import com.products.sbpg.model.Product;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los productos.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
public interface IProductService {
	/**
	 * Recupera todos los productos
	 * 
	 * @return Lista de ProductDTO.
	 */
	public List<Product> getAllProducts();

	/**
	 * Agrega un nuevo producto.
	 * 
	 * @param aName      	es el nombre del producto.
	 * @param aDescription 	es el nombre de producto del nuevo producto.
	 * @return un DTO que representa al producto recientemente creado.
	 */
	public ProductDTO addProduct(String aName, String aDescription);

	/**
	 * Edita el nombre de un producto.
	 * 
	 * @param id   es el identificador del producto.
	 * @param name es el nuevo nombre.
	 */
	public void editProduct(long id, String name);
}
