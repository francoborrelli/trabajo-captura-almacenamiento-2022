/**
 * Este paquete contiene las clases que definen la api rest de la aplicación.
 */
package com.products.sbpg.controller;

import org.slf4j.*;
import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.sbpg.SbpgApplication;
import com.products.sbpg.dto.ProductRequestDTO;
import com.products.sbpg.exception.ResourceNotFoundException;
import com.products.sbpg.model.Product;
import com.products.sbpg.service.IProductService;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase presenta los diferentes "endpoints" de la api rest.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    // for logging
	private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);
	
	/**
	 * Es el servicio relacionado con los productos.
	 */
	@Inject
	private IProductService productsService;

	/**
	 * Endpoint para recuperar todos los productos.
	 * 
	 */
    @GetMapping("/products")
	public List<Product> getAllProducts() {
		logger.info("listing all products...");
		return this.productsService.findAll();
	}
	
  @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable(value = "id") long productId) throws ResourceNotFoundException {
        logger.info("getting product with id: {}", productId);
        return this.productsService.findById(productId);
    }

	/**
	 * Endpoint para crear productos.
	 * 
	 * @param aProductRequestDTO dto que contiene la información del producto a crear.
	 * 
	 */
	@PostMapping("/products")
	public void createProduct(@RequestBody ProductRequestDTO aProductRequestDTO) {

		this.getProductsService().addProduct(aProductRequestDTO.name, aProductRequestDTO.description, aProductRequestDTO.brandId);
	}

	/**
	 * Endpoint para crear productos.
	 * 
	 * @param aProductRequestDTO dto que contiene la información del producto a crear.
	 * 
	 */
	@PutMapping("/products")
	public void editProduct(@RequestBody ProductRequestDTO aProductRequestDTO) {

		this.getProductsService().editProduct(aProductRequestDTO.id, aProductRequestDTO.name);
	}

	/**
	 * Getter.
	 * 
	 * @return el servicio relacionado con los productos.
	 */
	public IProductService getProductsService() {
		return this.productsService;
	}

}
