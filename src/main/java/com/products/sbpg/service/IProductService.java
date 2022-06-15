/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.products.sbpg.service;

import java.util.List;
import java.util.Optional;

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
	public List<Product> findAll();

	/**
	 * Recupera un product
	 * 
	 * @return el producto con el id indicado
	 */
	public Optional<Product> findById(long anId);
}
