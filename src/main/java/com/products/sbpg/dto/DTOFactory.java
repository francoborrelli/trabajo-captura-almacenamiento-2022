/**
 * Este paquete contiene las clases que se utilizan para transferir información de las 
 * distintas instancias entre capas.
 */
package com.products.sbpg.dto;

import org.springframework.stereotype.Component;

import com.products.sbpg.model.Product;

/**
 * Las instancias de esta clase se utilizan para crear DTOs en forma
 * centralizada.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@Component
public class DTOFactory {

	/**
	 * Crea un DTO que representará a un producto.
	 * 
	 * @param aProduct es el producto que debe ser representado.
	 * @return un DTO con los datos básicos.
	 */
	public ProductDTO createProductDTO(Product aProduct) {
		return new ProductDTO(aProduct.getId(), aProduct.getName(), aProduct.getDescription(), aProduct.version);
	}

}
