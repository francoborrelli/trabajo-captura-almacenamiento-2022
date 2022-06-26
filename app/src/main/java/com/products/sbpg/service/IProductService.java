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
	 * Recupera los productos mediante full text search
	 * 
	 * @return Lista de ProductDTO.
	 */
	public List<Product> search(String aTerm);

	/**
	 * Recupera los productos mediante full text search solo fijandose en los campos de producto
	 * 
	 * @return Lista de ProductDTO.
	 */
	public List<Product> searchByProductOnly(String aTerm);


	/**
	 * Recupera un product
	 * 
	 * @return el producto con el id indicado
	 */
	public Optional<Product> findById(long anId);
}
