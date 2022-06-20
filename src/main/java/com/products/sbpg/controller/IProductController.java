package com.products.sbpg.controller;

import java.util.List;
import java.util.Optional;

import com.products.sbpg.model.Product;
import com.products.sbpg.exception.ResourceNotFoundException;

public interface IProductController {
    /**
	 * Endpoint para recuperar todos los productos.
	 * 
	 */
	List<Product> searchProducts(String aTerm);

    /**
	 * Endpoint para crear productos.
	 * 
	 * @param productId recupera un producto por su id, o genera una excepción en caso de no encontrarlo.
	 * 
	 */
    Optional<Product> getProductById(long productId) throws ResourceNotFoundException;
}
